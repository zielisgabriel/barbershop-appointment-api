package br.com.gabriel.barbershop_appointment_api.mappers;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;

@Component
public class CustomerMapper {
    public Customer map(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerEmail(customerDTO.getCustomerEmail());
        customer.setCustomerPassword(customerDTO.getCustomerPassword());

        return customer;
    }
}
