package br.com.gabriel.barbershop_appointment_api.repositories;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Should find customer by email")
    public void findByCustomerEmailSuccess() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Test Name");
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerPassword("testpassword123");
        this.createCustomer(customerDTO);

        Optional<Customer> foundedCustomer = this.customerRepository.findByCustomerEmail("testemail@email.com");

        assertThat(foundedCustomer.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not return the customer")
    public void findByCustomerEmailFailure() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Test Name");
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerPassword("testpassword123");
        this.createCustomer(customerDTO);

        Optional<Customer> foundedCustomerFailure = this.customerRepository.findByCustomerEmail("failureemail@email.com");

        assertThat(foundedCustomerFailure.isEmpty()).isTrue();
    }

    private Customer createCustomer(CustomerDTO customerDTO) {
        CustomerMapper customerMapper = new CustomerMapper();
        Customer customer = customerMapper.map(customerDTO);
        this.entityManager.persist(customer);
        return customer;
    }
}
