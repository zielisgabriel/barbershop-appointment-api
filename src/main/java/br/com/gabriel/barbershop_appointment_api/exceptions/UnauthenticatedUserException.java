package br.com.gabriel.barbershop_appointment_api.exceptions;

public class UnauthenticatedUserException extends RuntimeException {
    public UnauthenticatedUserException() {
        super("Usuário não autenticado.");
    }
}
