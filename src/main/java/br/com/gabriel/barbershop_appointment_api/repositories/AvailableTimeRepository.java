package br.com.gabriel.barbershop_appointment_api.repositories;

import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.models.AvailableTime;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, UUID> {
    Optional<AvailableTime> findByAvailableTimeId(UUID availableTimeId);
    boolean existsByTime(LocalTime time);
}
