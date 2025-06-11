package br.com.gabriel.barbershop_appointment_api.services;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public void execute(CustomerDTO customerDTO) {
        customerRepository.findByEmail(customerDTO.getCustomer_email()).ifPresent(customer -> {
            throw new RuntimeException("Customer already exists");
        });

        Customer customer = customerMapper.map(customerDTO);
        customerRepository.save(customer);
    }
}
