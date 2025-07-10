package br.com.gabriel.barbershop_appointment_api.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;

public interface AppointmentTimeRepository extends JpaRepository<AppointmentTime, UUID> {
    Optional<AppointmentTime> findByAppointmentTimeId(UUID appointmentTimeId);
    Optional<AppointmentTime> findByCustomer(Customer customer);
    List<AppointmentTime> findByCustomerCustomerId(UUID customerId);
    Optional<AppointmentTime> findByAppointmentDateTime(LocalDateTime appointmentDateTime);
    void deleteByAppointmentDateTimeBefore(LocalDateTime appointmentDateTime);
}
