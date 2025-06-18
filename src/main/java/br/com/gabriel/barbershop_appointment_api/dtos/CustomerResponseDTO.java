package br.com.gabriel.barbershop_appointment_api.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseDTO {
    private UUID customerId;
    private String customerName;
}
