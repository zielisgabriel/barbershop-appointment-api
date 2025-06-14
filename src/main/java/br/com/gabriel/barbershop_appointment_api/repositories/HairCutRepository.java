package br.com.gabriel.barbershop_appointment_api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.models.HairCut;

public interface HairCutRepository extends JpaRepository<HairCut, UUID> {
    public Optional<HairCut> findByHairCutId(UUID hairCutName);
    public Optional<HairCut> findByHairCutName(String haircutName);
}
