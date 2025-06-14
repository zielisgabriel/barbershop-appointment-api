package br.com.gabriel.barbershop_appointment_api.services;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.HairCutMapper;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateHairCutService {
    private final HairCutRepository hairCutRepository;
    private final HairCutMapper hairCutMapper;

    public void execute(HairCutDTO hairCutDTO) {
        if (hairCutRepository.findByHairCutName(hairCutDTO.getHairCutName()).isPresent()) {
            throw new HairCutAlreadyExistsException();
        }

        HairCut hairCut = hairCutMapper.map(hairCutDTO);

        hairCutRepository.save(hairCut);
    }
}
