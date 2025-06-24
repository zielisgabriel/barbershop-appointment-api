package br.com.gabriel.barbershop_appointment_api.mappers;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.domain.AvailableTime;
import br.com.gabriel.barbershop_appointment_api.dtos.AvailableTimeDTO;

@Component
public class AvailableTimeMapper {
    public AvailableTime map(AvailableTimeDTO availableTimeDTO) {
        AvailableTime availableTime = new AvailableTime();
        availableTime.setTime(availableTimeDTO.getTime());
        return availableTime;
    }
}
