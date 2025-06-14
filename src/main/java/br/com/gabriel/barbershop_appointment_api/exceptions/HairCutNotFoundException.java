package br.com.gabriel.barbershop_appointment_api.exceptions;

public class HairCutNotFoundException extends RuntimeException {
    public HairCutNotFoundException() {
        super("Corte de cabelo não foi encontrado.");
    }
}
