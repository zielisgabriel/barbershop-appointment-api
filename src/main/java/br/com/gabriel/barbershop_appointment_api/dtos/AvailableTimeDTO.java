package br.com.gabriel.barbershop_appointment_api.dtos;

import java.time.LocalTime;

import lombok.Data;

@Data
public class AvailableTimeDTO {
    private LocalTime time;
}
