package br.com.gabriel.barbershop_appointment_api.exceptions;

public class TimeNotFoundException extends RuntimeException {
    public TimeNotFoundException() {
        super("Horário não encontrado.");
    }
}
