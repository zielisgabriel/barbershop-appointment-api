package br.com.gabriel.barbershop_appointment_api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.domain.HairCut;

public interface HairCutRepository extends JpaRepository<HairCut, UUID> {
    public Optional<HairCut> findByHairCutId(UUID hairCutName);
    public Optional<HairCut> findByHairCutName(String haircutName);
}
