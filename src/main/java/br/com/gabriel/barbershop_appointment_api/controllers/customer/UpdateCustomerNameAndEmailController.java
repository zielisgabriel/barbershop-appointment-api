package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.services.customer.UpdateCustomerNameAndEmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UpdateCustomerNameAndEmailController {
    private final UpdateCustomerNameAndEmailService updateCustomerNameAndEmailService;

    @PutMapping("/customer/update/{customerId}")
    public void update(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable UUID customerId) {
        this.updateCustomerNameAndEmailService.execute(customerId, customerDTO);
    }
}
