package br.com.gabriel.barbershop_appointment_api.mappers;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.models.Customer;

public class CustomerMapper {
    public Customer map(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCustomer_name(customerDTO.getCustomer_name());
        customer.setCustomer_email(customerDTO.getCustomer_email());
        customer.setCustomer_password(customerDTO.getCustomer_password());

        return customer;
    }
}
