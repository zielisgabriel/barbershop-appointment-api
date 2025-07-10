package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.services.customer.GetCustomerDetailsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GetCustomerDetailsController {
    private final GetCustomerDetailsService getCustomerDetailsService;

    @GetMapping("/customer/details")
    public Customer getCustomerDetails() {
        Customer customer = this.getCustomerDetailsService.execute();
        return customer;
    }
}
