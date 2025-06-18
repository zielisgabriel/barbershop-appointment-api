package br.com.gabriel.barbershop_appointment_api.exceptions;

public class AppointmentTimeAlreadyExists extends RuntimeException {
    public AppointmentTimeAlreadyExists() {
        super("Já existe um horário marcado.");
    }
}
