package br.com.gabriel.barbershop_appointment_api.controllers.available_time;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.AvailableTimeDTO;
import br.com.gabriel.barbershop_appointment_api.services.available_time.CreateAvailableTimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateAvailableTimeController {
    private final CreateAvailableTimeService createAvailableTimeService;

    @PostMapping("/available_time/create")
    public ResponseEntity<Void> create(@RequestBody AvailableTimeDTO availableTimeDTO) {
        this.createAvailableTimeService.execute(availableTimeDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
