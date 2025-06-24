package br.com.gabriel.barbershop_appointment_api.services.customer;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;

    public void execute(CustomerDTO customerDTO) throws UserAlreadyExistsException {
        this.customerRepository
            .findByCustomerEmail(customerDTO.getCustomerEmail())
            .ifPresent(customer -> {
                throw new UserAlreadyExistsException();
            });

        String passwordCrypted = passwordEncoder.encode(customerDTO.getCustomerPassword());

        Customer customer = this.customerMapper.map(customerDTO);
        customer.setCustomerPassword(passwordCrypted);

        this.customerRepository.save(customer);
    }
}
