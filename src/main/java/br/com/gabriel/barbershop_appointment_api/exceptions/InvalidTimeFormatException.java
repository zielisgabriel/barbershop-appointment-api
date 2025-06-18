package br.com.gabriel.barbershop_appointment_api.exceptions;

public class InvalidTimeFormatException extends RuntimeException {
    public InvalidTimeFormatException() {
        super("A hora deve ser no formato HH:00.");
    }
}
