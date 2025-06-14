package br.com.gabriel.barbershop_appointment_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.services.ListHairCutsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListHairCutsController {
    private final ListHairCutsService listHairCutsService;

    @GetMapping("/haircut/list")
    public List<HairCut> list() {
        List<HairCut> hairCuts = this.listHairCutsService.execute();
        return hairCuts;
    }
}
