package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.services.customer.CreateCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateCustomerController {
    private final CreateCustomerService createCustomerService;

    @PostMapping("/customer/create")
    public void create(@Valid @RequestBody CustomerDTO customerDTO) {
        this.createCustomerService.execute(customerDTO);
    }
}
