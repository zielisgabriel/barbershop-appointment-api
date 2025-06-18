package br.com.gabriel.barbershop_appointment_api.controllers.available_time;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.models.AvailableTime;
import br.com.gabriel.barbershop_appointment_api.services.available_time.ListAvailableTimesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListAvailableTimesController {
    private final ListAvailableTimesService listAvailableTimesService;

    @GetMapping("/available_time/list")
    public List<AvailableTime> list() {
        List<AvailableTime> availableTimes = this.listAvailableTimesService.execute();

        return availableTimes;
    }
}
