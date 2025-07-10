package br.com.gabriel.barbershop_appointment_api.controllers.appointment_time;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.services.appointment_time.DeleteAppointmentTimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeleteAppointmentTimeController {
    private final DeleteAppointmentTimeService deleteAppointmentTimeService;

    @DeleteMapping("/appointmentTime/delete/{appointmentTimeId}")
    public void delete(@PathVariable UUID appointmentTimeId) {
        this.deleteAppointmentTimeService.execute(appointmentTimeId);
    }
}
