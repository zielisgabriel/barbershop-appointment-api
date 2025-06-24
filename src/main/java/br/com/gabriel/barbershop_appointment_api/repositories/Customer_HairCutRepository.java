package br.com.gabriel.barbershop_appointment_api.repositories;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.Customer_HairCut;

public interface Customer_HairCutRepository extends JpaRepository<Customer_HairCut, UUID> {
    Optional<Customer_HairCut> findByCustomerHaircutId(UUID customerHaircutId);
    Optional<Customer_HairCut> findByCustomer(Customer customer);
    Optional<Customer_HairCut> findByAppointmentDateTime(LocalDateTime appointmentDateTime);
}
