package br.com.gabriel.barbershop_appointment_api.services.customer;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public void execute(CustomerDTO customerDTO) throws UserAlreadyExistsException {
        this.customerRepository
            .findByCustomerEmail(customerDTO.getCustomerEmail())
            .ifPresent(customer -> {
                throw new UserAlreadyExistsException();
            });

        Customer customer = this.customerMapper.map(customerDTO);
        this.customerRepository.save(customer);
    }
}
