package br.com.gabriel.barbershop_appointment_api.exceptions;

public class UserAlreadyExistsInAppointmentTimeListException extends RuntimeException {
    public UserAlreadyExistsInAppointmentTimeListException() {
        super("Outro usuário possui esse horário marcado.");
    }
}
