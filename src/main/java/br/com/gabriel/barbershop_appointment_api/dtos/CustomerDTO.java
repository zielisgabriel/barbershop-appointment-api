package br.com.gabriel.barbershop_appointment_api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String customer_name;

    @Email
    private String customer_email;

    @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
    private String customer_password;
}
