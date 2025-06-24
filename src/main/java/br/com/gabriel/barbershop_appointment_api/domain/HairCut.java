package br.com.gabriel.barbershop_appointment_api.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
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
    @Column(name = "haircut_id")
    private UUID hairCutId;

    @Column(name = "haircut_name", nullable = false, unique = true)
    private String hairCutName;

    @Column(name = "haircut_price", nullable = false)
    private BigDecimal hairCutPrice;

    @Column(name = "haircut_description", nullable = false)
    private String hairCutDescription;
}
