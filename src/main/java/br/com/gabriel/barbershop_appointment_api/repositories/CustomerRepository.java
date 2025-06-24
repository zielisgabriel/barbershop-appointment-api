package br.com.gabriel.barbershop_appointment_api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByCustomerEmail(String email);
    Optional<Customer> findByCustomerId(UUID customerId);
}
