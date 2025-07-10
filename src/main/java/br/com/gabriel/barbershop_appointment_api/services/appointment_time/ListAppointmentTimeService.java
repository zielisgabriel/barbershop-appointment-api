package br.com.gabriel.barbershop_appointment_api.services.appointment_time;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;
import br.com.gabriel.barbershop_appointment_api.exceptions.UnauthenticatedUserException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import br.com.gabriel.barbershop_appointment_api.repositories.AppointmentTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListAppointmentTimeService {
    private final AppointmentTimeRepository customer_HairCutRepository;
    private final CustomerRepository customerRepository;

    public List<AppointmentTime> execute(UUID customerId) {
        if (customerId != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Customer customer = this.customerRepository.findByCustomerId(UUID.fromString(customerId.toString())).orElseThrow(() -> new UserNotFoundException());
            if (!authentication.getName().equals(customer.getCustomerEmail()) || authentication == null) {
                throw new UnauthenticatedUserException();
            };

            List<AppointmentTime> appointments = this.customer_HairCutRepository.findByCustomerCustomerId(customer.getCustomerId());
            return appointments;
        }

        List<AppointmentTime> appointments = this.customer_HairCutRepository.findAll(Sort.by(Sort.Direction.ASC, "appointmentDateTime"));
        return appointments;
    }
}
