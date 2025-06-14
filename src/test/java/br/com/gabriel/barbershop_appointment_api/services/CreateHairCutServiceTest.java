package br.com.gabriel.barbershop_appointment_api.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.dtos.HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.HairCutMapper;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;

@ActiveProfiles("test")
public class CreateHairCutServiceTest {
    @InjectMocks
    private CreateHairCutService createHairCutService;

    @Mock
    private HairCutRepository hairCutRepository;

    @Mock
    private HairCutMapper hairCutMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create a new hair cut")
    public void executeSuccess() {
        HairCutDTO hairCutDTO = new HairCutDTO();
        hairCutDTO.setHairCutName("Corte 1");
        hairCutDTO.setHairCutPrice(BigDecimal.valueOf(10));
        hairCutDTO.setHairCutDescription("Descrição do corte 1");

        HairCut hairCut = new HairCut();
        hairCut.setHairCutId(UUID.randomUUID());

        when(this.hairCutMapper.map(hairCutDTO)).thenReturn(hairCut);
        when(this.hairCutRepository.save(hairCut)).thenReturn(hairCut);

        this.createHairCutService.execute(hairCutDTO);

        verify(this.hairCutRepository).save(hairCut);
    }

    @Test
    public void executeFailure() {
        HairCutDTO hairCutDTO = new HairCutDTO();
        hairCutDTO.setHairCutName("Corte 1");
        hairCutDTO.setHairCutPrice(BigDecimal.valueOf(10));
        hairCutDTO.setHairCutDescription("Descrição do corte 1");

        when(this.hairCutRepository.findByHairCutName("Corte 1")).thenReturn(Optional.of(new HairCut()));

        assertThatThrownBy(() -> this.createHairCutService.execute(hairCutDTO))
        .isInstanceOf(HairCutAlreadyExistsException.class)
        .hasMessage("Já existe um corte de cabelo com esse nome.");
    }
}
