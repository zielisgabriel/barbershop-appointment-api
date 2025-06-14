package br.com.gabriel.barbershop_appointment_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_haircut")
public class Customer_HairCut {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_haircut_id", nullable = false)
    private UUID customerHaircutId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "haircut_id", nullable = false)
    private HairCut haircut;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "appointment_date_time", nullable = false)
    LocalDateTime appointmentDateTime;
}
