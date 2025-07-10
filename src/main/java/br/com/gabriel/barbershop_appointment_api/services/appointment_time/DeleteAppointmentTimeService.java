package br.com.gabriel.barbershop_appointment_api.services.appointment_time;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;
import br.com.gabriel.barbershop_appointment_api.exceptions.CustomerHairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UnauthenticatedUserException;
import br.com.gabriel.barbershop_appointment_api.repositories.AppointmentTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAppointmentTimeService {
    private final AppointmentTimeRepository customer_HairCutRepository;

    public void execute(UUID appointmentTimeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new UnauthenticatedUserException();
        };

        AppointmentTime appointmentTime = this.customer_HairCutRepository
            .findByAppointmentTimeId(appointmentTimeId)
            .orElseThrow(() -> new CustomerHairCutNotFoundException());

        if (!authentication.getName().equals(appointmentTime.getCustomer().getCustomerEmail())) {
            throw new UnauthenticatedUserException();
        }
        
        this.customer_HairCutRepository.delete(appointmentTime);
    }
}
