package br.com.gabriel.barbershop_appointment_api.services.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerResponseDTO;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListCustomersService {
    private final CustomerRepository customerRepository;

    public List<CustomerResponseDTO> execute() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customersWithoutIdAndPassword = new ArrayList<CustomerResponseDTO>();
        
        customers.forEach(customer -> {
            CustomerResponseDTO responseCustomerDTO = new CustomerResponseDTO(customer.getCustomerId(), customer.getCustomerName());
            customersWithoutIdAndPassword.add(responseCustomerDTO);
        });

        return customersWithoutIdAndPassword;
    }
}
