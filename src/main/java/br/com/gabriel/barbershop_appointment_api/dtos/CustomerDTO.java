package br.com.gabriel.barbershop_appointment_api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CustomerDTO {
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    String customer_name;

    @Email
    String customer_email;

    @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
    String customer_password;
}
