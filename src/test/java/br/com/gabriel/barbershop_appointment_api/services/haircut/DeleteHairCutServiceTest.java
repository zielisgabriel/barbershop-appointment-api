package br.com.gabriel.barbershop_appointment_api.services.haircut;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.exceptions.HairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;

@ActiveProfiles("test")
public class DeleteHairCutServiceTest {
    @InjectMocks
    private DeleteHairCutService deleteHairCutService;

    @Mock
    private HairCutRepository hairCutRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should delete a hair cut")
    public void executeSuccess() {
        UUID uuid = UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a");
        HairCut hairCut = new HairCut();
        hairCut.setHairCutId(uuid);

        when(this.hairCutRepository.findByHairCutId(uuid)).thenReturn(Optional.of(hairCut));

        this.deleteHairCutService.execute(hairCut.getHairCutId());

        verify(this.hairCutRepository).delete(hairCut);
    }

    @Test
    @DisplayName("Should throw exception when hair cut not found")
    public void executeFailure() {
        UUID uuid = UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a");

        when(this.hairCutRepository.findByHairCutId(uuid)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.deleteHairCutService.execute(uuid))
            .isInstanceOf(HairCutNotFoundException.class)
            .hasMessage("Corte de cabelo não foi encontrado.");
    }
}
