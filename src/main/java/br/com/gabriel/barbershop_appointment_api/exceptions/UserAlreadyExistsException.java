package br.com.gabriel.barbershop_appointment_api.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Já existe um usuário com esse email.");
    }
}
