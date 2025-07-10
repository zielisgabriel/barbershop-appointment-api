package br.com.gabriel.barbershop_appointment_api.controllers.haircut;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.services.haircut.CreateHairCutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateHairCutController {
    private final CreateHairCutService createHairCutService;

    @PostMapping("/haircut/create")
    public ResponseEntity<Void> create(@Valid @RequestBody HairCutDTO hairCutDTO) {
        this.createHairCutService.execute(hairCutDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
