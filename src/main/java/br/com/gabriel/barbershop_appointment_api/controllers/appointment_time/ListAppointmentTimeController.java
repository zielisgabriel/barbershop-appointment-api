package br.com.gabriel.barbershop_appointment_api.controllers.appointment_time;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.domain.AppointmentTime;
import br.com.gabriel.barbershop_appointment_api.services.appointment_time.ListAppointmentTimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListAppointmentTimeController {
    private final ListAppointmentTimeService listAppointmentTimeService;

    @GetMapping("/appointmentTime/list")
    public List<AppointmentTime> list(@RequestParam(required = false) UUID customerId) {
        List<AppointmentTime> customer_HairCuts = this.listAppointmentTimeService.execute(customerId);
        return customer_HairCuts;
    }
}
