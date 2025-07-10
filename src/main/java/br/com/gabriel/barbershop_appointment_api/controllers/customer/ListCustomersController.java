package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.services.customer.ListCustomersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListCustomersController {
    private final ListCustomersService listCustomersService;

    @GetMapping("/customer/list")
    public List<Customer> list() {
        List<Customer> customerWithoutIdAndPassword = listCustomersService.execute();
        return customerWithoutIdAndPassword;
    }
}
