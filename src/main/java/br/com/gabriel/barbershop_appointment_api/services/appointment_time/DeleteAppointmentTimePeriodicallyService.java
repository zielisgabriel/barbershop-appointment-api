package br.com.gabriel.barbershop_appointment_api.services.appointment_time;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.repositories.AppointmentTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAppointmentTimePeriodicallyService {
    private final AppointmentTimeRepository appointmentTimeRepository;

    @Scheduled(fixedRate = 1800000)
    public void execute() {
        this.appointmentTimeRepository.deleteByAppointmentDateTimeBefore(LocalDateTime.now());
    }
}
