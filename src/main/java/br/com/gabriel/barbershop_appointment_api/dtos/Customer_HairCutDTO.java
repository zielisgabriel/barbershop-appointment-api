package br.com.gabriel.barbershop_appointment_api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Customer_HairCutDTO {
    @org.hibernate.validator.constraints.UUID
    UUID customer_id;
    @org.hibernate.validator.constraints.UUID
    UUID haircut_id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime appointmentDateTime;
}
