package br.com.gabriel.barbershop_appointment_api.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.services.DeleteHairCutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeleteHairCutController {
    private final DeleteHairCutService deleteHairCutService;

    @DeleteMapping("/haircut/delete/{hairCutId}")
    public void delete(@PathVariable UUID hairCutId) {
        this.deleteHairCutService.execute(hairCutId);
    }
}
