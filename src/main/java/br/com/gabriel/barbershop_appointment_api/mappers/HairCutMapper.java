package br.com.gabriel.barbershop_appointment_api.mappers;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.domain.HairCut;
import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;

@Component
public class HairCutMapper {
    public HairCut map(HairCutDTO hairCutDTO) {
        HairCut hairCut = new HairCut();
        hairCut.setHairCutName(hairCutDTO.getHairCutName());
        hairCut.setHairCutPrice(hairCutDTO.getHairCutPrice());
        hairCut.setHairCutDescription(hairCutDTO.getHairCutDescription());
        return hairCut;
    }
}
