package br.com.gabriel.barbershop_appointment_api.services.available_time;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.AvailableTime;
import br.com.gabriel.barbershop_appointment_api.dtos.AvailableTimeDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.InvalidTimeFormatException;
import br.com.gabriel.barbershop_appointment_api.exceptions.TimeAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.AvailableTimeMapper;
import br.com.gabriel.barbershop_appointment_api.repositories.AvailableTimeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAvailableTimeService {
    private final AvailableTimeRepository availableTimeRepository;
    private final AvailableTimeMapper availableTimeMapper;

    public void execute(AvailableTimeDTO availableTimeDTO) {
        if (availableTimeDTO.getTime().getMinute() != 0 || availableTimeDTO.getTime().getSecond() != 0) {
            throw new InvalidTimeFormatException();
        }

        boolean isExistsTime = this.availableTimeRepository.existsByTime(availableTimeDTO.getTime());

        if (isExistsTime) {
            throw new TimeAlreadyExistsException();
        }

        AvailableTime availableTime = availableTimeMapper.map(availableTimeDTO);

        this.availableTimeRepository.save(availableTime);
    }
}
