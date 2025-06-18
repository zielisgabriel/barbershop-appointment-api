package br.com.gabriel.barbershop_appointment_api.controllers.customer_haircut;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.services.customer_haircut.DeleteCustomer_HairCutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeleteCustomer_HairCutController {
    private final DeleteCustomer_HairCutService deleteCustomer_HairCutService;

    @DeleteMapping("/customer_haircut/delete/{customerHairCutId}")
    public void delete(@PathVariable UUID customerHairCutId) {
        this.deleteCustomer_HairCutService.execute(customerHairCutId);
    }
}
