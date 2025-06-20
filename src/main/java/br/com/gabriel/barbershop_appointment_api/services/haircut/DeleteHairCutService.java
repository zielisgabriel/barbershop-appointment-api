package br.com.gabriel.barbershop_appointment_api.services.haircut;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteHairCutService {
    private final HairCutRepository hairCutRepository;

    public void execute(UUID haircutId) {
        Optional<HairCut> hairCut = hairCutRepository.findByHairCutId(haircutId);

        if (!hairCut.isPresent()) {
            throw new HairCutNotFoundException();
        }

        this.hairCutRepository.delete(hairCut.get());
    }
}
