package br.com.gabriel.barbershop_appointment_api.exceptions;

public class CustomerAlreadyHasAppointmentException extends RuntimeException {
    public CustomerAlreadyHasAppointmentException() {
        super("Você já possui um horário marcado.");
    }
}
