package br.com.gabriel.barbershop_appointment_api.services.appointment_time;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;
import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import br.com.gabriel.barbershop_appointment_api.dtos.AppointmentTimeDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.exceptions.InvalidDateTimeException;
import br.com.gabriel.barbershop_appointment_api.exceptions.TimeNotFoundException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsInAppointmentTimeListException;
import br.com.gabriel.barbershop_appointment_api.exceptions.CustomerAlreadyHasAppointmentException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.mappers.AppointmentTimeMapper;
import br.com.gabriel.barbershop_appointment_api.repositories.AvailableTimeRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.AppointmentTimeRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAppointmentTimeService {
    private final AppointmentTimeRepository customer_HairCutRepository;
    private final CustomerRepository customerRepository;
    private final HairCutRepository hairCutRepository;
    private final AppointmentTimeMapper customer_HairCutMapper;
    private final AvailableTimeRepository availableTimeRepository;

    public void execute(AppointmentTimeDTO appointmentTimeDTO) {
        this.ensureValidDateTime(appointmentTimeDTO.getAppointmentDateTime());

        Customer customer = this.customerRepository
            .findByCustomerId(appointmentTimeDTO.getCustomerId())
            .orElseThrow(() -> new UserNotFoundException());

        this.ensureCustomerIsNotInList(customer);

        this.ensureAppointmentTimeIsAvailable(appointmentTimeDTO.getAppointmentDateTime());

        HairCut hairCut = this.hairCutRepository
            .findByHairCutId(appointmentTimeDTO.getHaircutId())
            .orElseThrow(() -> new HairCutNotFoundException());

        AppointmentTime customer_HairCut = customer_HairCutMapper.map(customer, hairCut, appointmentTimeDTO.getAppointmentDateTime());

        this.customer_HairCutRepository.save(customer_HairCut);
    }

    private void ensureValidDateTime(LocalDateTime appointmentDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (appointmentDateTime.isBefore(currentDateTime)) {
            throw new InvalidDateTimeException();
        }

        if (appointmentDateTime.isAfter(currentDateTime.plusMonths(1))) {
            throw new InvalidDateTimeException();
        }

        boolean isExistsTime = this.availableTimeRepository.existsByTime(appointmentDateTime.toLocalTime());
        if (!isExistsTime) {
            throw new TimeNotFoundException();
        }
    }

    private void ensureCustomerIsNotInList(Customer customer) {
        Optional<AppointmentTime> customerInAppointmentTimeList = this.customer_HairCutRepository.findByCustomer(customer);
        if (customerInAppointmentTimeList.isPresent()) {
            throw new CustomerAlreadyHasAppointmentException();
        }
    }

    private void ensureAppointmentTimeIsAvailable(LocalDateTime appointmentDateTime) {
        Optional<AppointmentTime> customer_HairCutWithSameDate = this.customer_HairCutRepository
            .findByAppointmentDateTime(appointmentDateTime);
        if (customer_HairCutWithSameDate.isPresent()) {
            throw new UserAlreadyExistsInAppointmentTimeListException();
        }
    }
}
