package br.com.gabriel.barbershop_appointment_api.controllers.available_time;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.services.available_time.DeleteAvailableTimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeleteAvailableTimeController {
    private final DeleteAvailableTimeService deleteAvailableTimeService;

    public void delete(@RequestBody UUID availableTimeId) {
        this.deleteAvailableTimeService.execute(availableTimeId);
    }
}
