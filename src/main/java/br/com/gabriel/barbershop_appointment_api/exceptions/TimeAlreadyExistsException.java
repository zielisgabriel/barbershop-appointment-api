package br.com.gabriel.barbershop_appointment_api.exceptions;

public class TimeAlreadyExistsException extends RuntimeException {
    public TimeAlreadyExistsException() {
        super("Horário já cadastrado.");
    }
}
