package br.com.gabriel.barbershop_appointment_api.services.haircut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.models.HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.HairCutRepository;

@ActiveProfiles("test")
public class ListHairCutsServiceTest {
    @InjectMocks
    private ListHairCutsService listHairCutsService;

    @Mock
    private HairCutRepository hairCutRepository;

    @BeforeEach
    private void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should list all hair cuts")
    public void executeSuccess() {
        HairCut hairCut1 = new HairCut();
        HairCut hairCut2 = new HairCut();

        hairCut1.setHairCutId(UUID.randomUUID());
        hairCut1.setHairCutName("Corte 1");
        hairCut1.setHairCutPrice(BigDecimal.valueOf(10));
        hairCut1.setHairCutDescription("Descrição do corte 1");

        hairCut2.setHairCutId(UUID.randomUUID());
        hairCut2.setHairCutName("Corte 2");
        hairCut2.setHairCutPrice(BigDecimal.valueOf(20));
        hairCut2.setHairCutDescription("Descrição do corte 2");

        List<HairCut> hairCuts = Arrays.asList(hairCut1, hairCut2);

        when(this.hairCutRepository.findAll()).thenReturn(hairCuts);

        assertThat(this.listHairCutsService.execute())
            .hasSize(2)
            .contains(hairCut1, hairCut2);
    }
}
