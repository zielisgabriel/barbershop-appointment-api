package br.com.gabriel.barbershop_appointment_api.controllers.customer_haircut;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.Customer_HairCutDTO;
import br.com.gabriel.barbershop_appointment_api.services.customer_haircut.CreateCustomer_HairCutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateCustomer_HairCutController {
    private final CreateCustomer_HairCutService createCustomer_HairCutService;

    @PostMapping("/customer_haircut/create")
    public void create(@RequestBody Customer_HairCutDTO customer_HairCutDTO) {
        this.createCustomer_HairCutService.execute(customer_HairCutDTO);
    }
}
