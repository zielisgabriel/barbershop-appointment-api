package br.com.gabriel.barbershop_appointment_api.services.customer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.exceptions.UnauthenticatedUserException;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetCustomerAuthenticatedService {
    private final CustomerRepository customerRepository;

    public void execute() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new UnauthenticatedUserException();
        };
        this.customerRepository.findByCustomerEmail(authentication.getName()).orElseThrow(() -> new UserNotFoundException());
    }
}
