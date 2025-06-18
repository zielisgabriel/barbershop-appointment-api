package br.com.gabriel.barbershop_appointment_api.controllers.customer_haircut;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.Customer_HairCutResponseDTO;
import br.com.gabriel.barbershop_appointment_api.services.customer_haircut.ListCustomer_HairCutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListCustomer_HairCutController {
    private final ListCustomer_HairCutService listCustomer_HairCutService;

    @GetMapping("/customer_haircut/list")
    public List<Customer_HairCutResponseDTO> list() {
        List<Customer_HairCutResponseDTO> customer_HairCuts = this.listCustomer_HairCutService.execute();
        return customer_HairCuts;
    }
}
