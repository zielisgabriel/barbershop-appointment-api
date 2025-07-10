package br.com.gabriel.barbershop_appointment_api.controllers.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RestController // TODO make service
@RequiredArgsConstructor
public class FindUserController {
    private final CustomerRepository customerRepository;

    @GetMapping("/user")
    public Customer findUser(org.springframework.security.core.Authentication authentication) {
        Customer customer = this.customerRepository.findByCustomerEmail(authentication.getName()).orElse(null);
        return customer;
    }
}
