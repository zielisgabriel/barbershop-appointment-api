package br.com.gabriel.barbershop_appointment_api.dtos;

import lombok.Data;

@Data
public class AuthCustomerDTO {
    private String username;
    private String password;
}
