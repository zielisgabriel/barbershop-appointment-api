package br.com.gabriel.barbershop_appointment_api.mappers;

import org.springframework.stereotype.Component;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.models.Customer;

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
