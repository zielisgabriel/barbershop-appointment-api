package br.com.gabriel.barbershop_appointment_api.services.available_time;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.AvailableTime;
import br.com.gabriel.barbershop_appointment_api.exceptions.AvailableTimeNotFoundException;
import br.com.gabriel.barbershop_appointment_api.repositories.AvailableTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAvailableTimeService {
    private final AvailableTimeRepository availableTimeRepository;

    public void execute(UUID availableTimeId) {
        AvailableTime availableTime = this.availableTimeRepository.findByAvailableTimeId(availableTimeId)
            .orElseThrow(() -> new AvailableTimeNotFoundException());

        this.availableTimeRepository.delete(availableTime);
    }
}
