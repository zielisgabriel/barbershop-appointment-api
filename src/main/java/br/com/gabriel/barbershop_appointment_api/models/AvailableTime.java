package br.com.gabriel.barbershop_appointment_api.models;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "available_time")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "available_time_id")
    private UUID availableTimeId;

    @Column(name = "time", nullable = false)
    private LocalTime time;
}
