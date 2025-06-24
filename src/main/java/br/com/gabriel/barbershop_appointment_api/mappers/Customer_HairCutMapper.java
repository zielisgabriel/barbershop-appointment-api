package br.com.gabriel.barbershop_appointment_api.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.Customer_HairCut;
import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Customer_HairCutMapper {
    public Customer_HairCut map(Customer customer, HairCut hairCut, LocalDateTime appointmentDateTime) {
        Customer_HairCut customer_HairCut = new Customer_HairCut();

        customer_HairCut.setCustomer(customer);
        customer_HairCut.setHaircut(hairCut);
        customer_HairCut.setAppointmentDateTime(appointmentDateTime);
        
        return customer_HairCut;
    }
}
