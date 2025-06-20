package br.com.gabriel.barbershop_appointment_api.services.haircut;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateHairCutService {
    private final HairCutRepository hairCutRepository;

    public void execute(UUID hairCutId, HairCutDTO hairCutDTO) {
        Optional<HairCut> hairCut = this.hairCutRepository.findByHairCutId(hairCutId);

        if (!hairCut.isPresent()) {
            throw new HairCutNotFoundException();
        }

        HairCut hairCutToUpdate = hairCut.get();
        hairCutToUpdate.setHairCutName(hairCutDTO.getHairCutName());
        hairCutToUpdate.setHairCutPrice(hairCutDTO.getHairCutPrice());
        hairCutToUpdate.setHairCutDescription(hairCutDTO.getHairCutDescription());

        this.hairCutRepository.save(hairCutToUpdate);
    }
}
