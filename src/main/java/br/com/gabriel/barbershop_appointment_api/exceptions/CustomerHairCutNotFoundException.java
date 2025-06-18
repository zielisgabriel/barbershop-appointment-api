package br.com.gabriel.barbershop_appointment_api.exceptions;

public class CustomerHairCutNotFoundException extends RuntimeException {
    public CustomerHairCutNotFoundException() {
        super("Não existe nenhum horário marcado nesse usuário.");
    }
}
