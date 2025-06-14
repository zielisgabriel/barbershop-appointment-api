package br.com.gabriel.barbershop_appointment_api.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.services.CreateHairCutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateHairCutController {
    private final CreateHairCutService createHairCutService;

    @PostMapping("/haircut/create")
    public void create(@RequestBody @Validated HairCutDTO hairCutDTO) {
        this.createHairCutService.execute(hairCutDTO);
    }
}
