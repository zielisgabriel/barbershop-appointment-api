package br.com.gabriel.barbershop_appointment_api.services.available_time;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.models.AvailableTime;
import br.com.gabriel.barbershop_appointment_api.repositories.AvailableTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListAvailableTimesService {
    private final AvailableTimeRepository availableTimeRepository;

    public List<AvailableTime> execute() {
        List<AvailableTime> availableTimes = availableTimeRepository.findAll();

        return availableTimes;
    }
}
