package br.com.gabriel.barbershop_appointment_api.services.customer_haircut;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.Customer_HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.exceptions.InvalidDateTimeException;
import br.com.gabriel.barbershop_appointment_api.exceptions.TimeNotFoundException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsInAppointmentTimeListException;
import br.com.gabriel.barbershop_appointment_api.exceptions.CustomerAlreadyHasAppointmentException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.mappers.Customer_HairCutMapper;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.models.Customer_HairCut;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.AvailableTimeRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.Customer_HairCutRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCustomer_HairCutService {
    private final Customer_HairCutRepository customer_HairCutRepository;
    private final CustomerRepository customerRepository;
    private final HairCutRepository hairCutRepository;
    private final Customer_HairCutMapper customer_HairCutMapper;
    private final AvailableTimeRepository availableTimeRepository;

    public void execute(Customer_HairCutDTO customer_HairCutDTO) {
        this.ensureValidDateTime(customer_HairCutDTO.getAppointmentDateTime());

        Customer customer = this.customerRepository
            .findByCustomerId(customer_HairCutDTO.getCustomerId())
            .orElseThrow(() -> new UserNotFoundException());

        this.ensureCustomerIsNotInList(customer);

        this.ensureAppointmentTimeIsAvailable(customer_HairCutDTO.getAppointmentDateTime());

        HairCut hairCut = this.hairCutRepository
            .findByHairCutId(customer_HairCutDTO.getHaircutId())
            .orElseThrow(() -> new HairCutNotFoundException());

        Customer_HairCut customer_HairCut = customer_HairCutMapper.map(customer, hairCut, customer_HairCutDTO.getAppointmentDateTime());

        this.customer_HairCutRepository.save(customer_HairCut);
    }

    private void ensureValidDateTime(LocalDateTime appointmentDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (appointmentDateTime.isBefore(currentDateTime)) {
            throw new InvalidDateTimeException();
        }

        boolean isExistsTime = this.availableTimeRepository.existsByTime(appointmentDateTime.toLocalTime());
        if (!isExistsTime) {
            throw new TimeNotFoundException();
        }
    }

    private void ensureCustomerIsNotInList(Customer customer) {
        Optional<Customer_HairCut> customerInCustomer_HairCutList = this.customer_HairCutRepository.findByCustomer(customer);
        if (customerInCustomer_HairCutList.isPresent()) {
            throw new CustomerAlreadyHasAppointmentException();
        }
    }

    private void ensureAppointmentTimeIsAvailable(LocalDateTime appointmentDateTime) {
        Optional<Customer_HairCut> customer_HairCutWithSameDate = this.customer_HairCutRepository
            .findByAppointmentDateTime(appointmentDateTime);
        if (customer_HairCutWithSameDate.isPresent()) {
            throw new UserAlreadyExistsInAppointmentTimeListException();
        }
    }
}
