package br.com.gabriel.barbershop_appointment_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseDTO {
    private String customerName;
    private String customerEmail;
}
