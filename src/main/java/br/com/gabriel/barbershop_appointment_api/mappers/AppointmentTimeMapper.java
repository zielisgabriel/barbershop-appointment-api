package br.com.gabriel.barbershop_appointment_api.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;
import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppointmentTimeMapper {
    public AppointmentTime map(Customer customer, HairCut hairCut, LocalDateTime appointmentDateTime) {
        AppointmentTime customer_HairCut = new AppointmentTime();

        customer_HairCut.setCustomer(customer);
        customer_HairCut.setHaircut(hairCut);
        customer_HairCut.setAppointmentDateTime(appointmentDateTime);
        
        return customer_HairCut;
    }
}
