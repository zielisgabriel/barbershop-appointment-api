package br.com.gabriel.barbershop_appointment_api.controllers.appointment_time;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.AppointmentTimeDTO;
import br.com.gabriel.barbershop_appointment_api.services.appointment_time.CreateAppointmentTimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateAppointmentTimeController {
    private final CreateAppointmentTimeService createAppointmentTimeService;

    @PostMapping("/appointmentTime/create")
    public ResponseEntity<Void> create(@RequestBody AppointmentTimeDTO appointmentTimeDTO) {
        this.createAppointmentTimeService.execute(appointmentTimeDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
