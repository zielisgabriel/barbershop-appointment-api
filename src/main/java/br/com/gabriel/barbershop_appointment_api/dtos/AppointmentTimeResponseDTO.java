package br.com.gabriel.barbershop_appointment_api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import lombok.Data;

@Data
public class AppointmentTimeResponseDTO {
    private UUID customerHaircutId;
    private Customer customer;
    private HairCut hairCut;
    private LocalDateTime appointmentDateTime;
}
