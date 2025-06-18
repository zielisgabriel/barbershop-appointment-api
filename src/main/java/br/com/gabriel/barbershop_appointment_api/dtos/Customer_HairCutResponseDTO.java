package br.com.gabriel.barbershop_appointment_api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import lombok.Data;

@Data
public class Customer_HairCutResponseDTO {
    private UUID customerHaircutId;
    private CustomerResponseDTO customer;
    private HairCut hairCut;
    private LocalDateTime appointmentDateTime;
}
