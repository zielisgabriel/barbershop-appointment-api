package br.com.gabriel.barbershop_appointment_api.mappers;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.dtos.AvailableTimeDTO;
import br.com.gabriel.barbershop_appointment_api.models.AvailableTime;

@Component
public class AvailableTimeMapper {
    public AvailableTime map(AvailableTimeDTO availableTimeDTO) {
        AvailableTime availableTime = new AvailableTime();
        availableTime.setTime(availableTimeDTO.getTime());
        return availableTime;
    }
}
