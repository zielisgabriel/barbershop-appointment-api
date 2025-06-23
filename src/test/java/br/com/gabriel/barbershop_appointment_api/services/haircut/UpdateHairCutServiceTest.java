package br.com.gabriel.barbershop_appointment_api.services.haircut;

import static org.assertj.core.api.Assertions.assertThat;
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
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;

@ActiveProfiles("test")
public class UpdateHairCutServiceTest {
    @InjectMocks
    private UpdateHairCutService updateHairCutService;

    @Mock
    private HairCutRepository hairCutRepository;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
   
    @Test
    @DisplayName("Should update a hair cut")
    public void executeSuccess() {
        HairCut hairCut = new HairCut();
        HairCutDTO hairCutDTO = new HairCutDTO();
        UUID hairCutUUID = UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a");

        hairCut.setHairCutId(hairCutUUID);
        hairCut.setHairCutName("Old Cut 1");
        hairCut.setHairCutPrice(BigDecimal.valueOf(10));
        hairCut.setHairCutDescription("Old description");

        when(this.hairCutRepository.findByHairCutId(hairCutUUID)).thenReturn(Optional.of(hairCut));

        hairCutDTO.setHairCutName("New Cut 1");
        hairCutDTO.setHairCutPrice(BigDecimal.valueOf(20));
        hairCutDTO.setHairCutDescription("New description");

        this.updateHairCutService.execute(hairCutUUID, hairCutDTO);

        verify(this.hairCutRepository).save(hairCut);
        assertThat(hairCut.getHairCutName()).isEqualTo("New Cut 1");
        assertThat(hairCut.getHairCutPrice()).isEqualTo(BigDecimal.valueOf(20));
        assertThat(hairCut.getHairCutDescription()).isEqualTo("New description");
    }
}
