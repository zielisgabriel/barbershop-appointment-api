package br.com.gabriel.barbershop_appointment_api.exceptions;

public class HairCutAlreadyExistsException extends RuntimeException {
    public HairCutAlreadyExistsException() {
        super("Já existe um corte de cabelo com esse nome.");
    }
}
