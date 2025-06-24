package br.com.gabriel.barbershop_appointment_api.services.customer;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateCustomerNameAndEmailService {
    private final CustomerRepository customerRepository;

    public void execute(UUID customerID, CustomerDTO customerDTO) {
        Customer customer = this.customerRepository
            .findByCustomerId(customerID)
            .orElseThrow(() -> new UserNotFoundException());

        Customer customerToUpdate = customer;
        customerToUpdate.setCustomerEmail(customerDTO.getCustomerEmail());
        customerToUpdate.setCustomerName(customerDTO.getCustomerName());
        this.customerRepository.save(customerToUpdate);
    }
}
