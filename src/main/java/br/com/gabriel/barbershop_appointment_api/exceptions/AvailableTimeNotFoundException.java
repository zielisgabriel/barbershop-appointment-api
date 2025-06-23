package br.com.gabriel.barbershop_appointment_api.exceptions;

public class AvailableTimeNotFoundException extends RuntimeException {
    public AvailableTimeNotFoundException() {
        super("Horário não encontrado.");
    }
}
