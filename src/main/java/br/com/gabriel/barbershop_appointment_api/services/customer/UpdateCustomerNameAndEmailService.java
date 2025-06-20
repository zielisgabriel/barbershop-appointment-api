package br.com.gabriel.barbershop_appointment_api.services.customer;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateCustomerNameAndEmailService {
    private final CustomerRepository customerRepository;

    public void execute(UUID customerID, CustomerDTO customerDTO) {
        Optional<Customer> customer = this.customerRepository.findByCustomerId(customerID);

        if (!customer.isPresent()) {
            throw new UserNotFoundException();
        }

        Customer customerToUpdate = customer.get();
        customerToUpdate.setCustomerEmail(customerDTO.getCustomerEmail());
        customerToUpdate.setCustomerName(customerDTO.getCustomerName());
        this.customerRepository.save(customerToUpdate);
    }
}
