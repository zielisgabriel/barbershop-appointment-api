package br.com.gabriel.barbershop_appointment_api.domain;

import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "appointment_time")
public class AppointmentTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "appointment_time_id", nullable = false)
    private UUID appointmentTimeId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "haircut_id", nullable = false)
    private HairCut haircut;

    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;
}
