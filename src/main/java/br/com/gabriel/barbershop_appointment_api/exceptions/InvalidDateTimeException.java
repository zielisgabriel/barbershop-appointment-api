package br.com.gabriel.barbershop_appointment_api.exceptions;

public class InvalidDateTimeException extends RuntimeException {
    public InvalidDateTimeException() {
        super("Data e hora inválida.");
    }
}
