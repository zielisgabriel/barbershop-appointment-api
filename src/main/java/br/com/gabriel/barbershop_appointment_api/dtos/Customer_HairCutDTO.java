package br.com.gabriel.barbershop_appointment_api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Customer_HairCutDTO {
    @org.hibernate.validator.constraints.UUID
    private UUID customerId;

    @org.hibernate.validator.constraints.UUID
    private UUID haircutId;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime appointmentDateTime;
}
