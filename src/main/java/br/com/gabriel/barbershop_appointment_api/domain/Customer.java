package br.com.gabriel.barbershop_appointment_api.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @JsonIgnore
    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @JsonIgnore
    @Column(name = "customer_password", nullable = false)
    private String customerPassword;

    @Column(name = "role", nullable = false)
    private String customerRole = "customer";
}
