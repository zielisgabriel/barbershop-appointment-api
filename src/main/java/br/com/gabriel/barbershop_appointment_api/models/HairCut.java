package br.com.gabriel.barbershop_appointment_api.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "haircuts")
@Data
public class HairCut {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID haircut_id;
    private String haircut_name;
    private BigDecimal haircut_price;
    private String haircut_description;
}
