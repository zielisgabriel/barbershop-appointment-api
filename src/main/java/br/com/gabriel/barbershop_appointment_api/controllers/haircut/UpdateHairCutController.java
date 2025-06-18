package br.com.gabriel.barbershop_appointment_api.controllers.haircut;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.services.haircut.UpdateHairCutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UpdateHairCutController {
    private final UpdateHairCutService hairCutService;

    @PutMapping("/haircut/update/{hairCutId}")
    public void update(@PathVariable UUID hairCutId, @Valid @RequestBody HairCutDTO hairCutDTO) {
        this.hairCutService.execute(hairCutId, hairCutDTO);
    }
}
