package br.com.gabriel.barbershop_appointment_api.services.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListCustomersService {
    private final CustomerRepository customerRepository;

    public List<Customer> execute() {
        List<Customer> customers = this.customerRepository.findAll();

        return customers;
    }
}
