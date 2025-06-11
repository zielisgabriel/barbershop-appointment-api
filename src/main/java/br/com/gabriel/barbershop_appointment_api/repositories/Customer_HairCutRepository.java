package br.com.gabriel.barbershop_appointment_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.models.Customer_HairCut;

public interface Customer_HairCutRepository extends JpaRepository<Customer_HairCut, UUID> {}
