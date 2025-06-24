package br.com.gabriel.barbershop_appointment_api.services.haircut;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListHairCutsService {
    private final HairCutRepository hairCutRepository;

    public List<HairCut> execute() {
        List<HairCut> hairCuts = hairCutRepository.findAll();

        return hairCuts;
    }
}
