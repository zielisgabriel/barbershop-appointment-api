package br.com.gabriel.barbershop_appointment_api.services.customer;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {
    private final CustomerRepository customerRepository;

    public void execute(UUID customerId) throws UserNotFoundException {
        this.customerRepository.findByCustomerId(customerId).ifPresentOrElse(customer -> {
            this.customerRepository.delete(customer);
        }, () -> {
            throw new UserNotFoundException();
        });
    }
}
