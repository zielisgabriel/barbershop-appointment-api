package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.services.customer.GetCustomerAuthenticatedService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ValidateCustomerAuthenticatedController {
    private final GetCustomerAuthenticatedService getCustomerAuthenticatedService;

    @GetMapping("/customer/validate")
    public void validate() {
        this.getCustomerAuthenticatedService.execute();
    }
}
