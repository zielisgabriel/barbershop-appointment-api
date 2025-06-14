package br.com.gabriel.barbershop_appointment_api.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HairCutDTO {
    String hairCutName;

    @Min(value = 0, message = "O preço deve ser maior ou igual a zero")
    @Max(value = 1000, message = "O preço deve ser menor ou igual a 1000")
    BigDecimal hairCutPrice;

    @Size(min = 3, max = 100, message = "A descrição deve ter entre 3 e 100 caracteres")
    String hairCutDescription;
}
