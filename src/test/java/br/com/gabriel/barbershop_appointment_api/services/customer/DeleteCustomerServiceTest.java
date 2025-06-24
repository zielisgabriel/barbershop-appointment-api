package br.com.gabriel.barbershop_appointment_api.services.customer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;

@ActiveProfiles("test")
public class DeleteCustomerServiceTest {
    @InjectMocks
    private DeleteCustomerService deleteCustomerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @BeforeEach
    private void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should delete a customer")
    void executeSuccess() {
        UUID uuid = UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerPassword("testpassword123");
        customerDTO.setCustomerName("Test Name");
        
        Customer customer = new Customer();
        customer.setCustomerId(uuid);

        when(this.customerMapper.map(customerDTO)).thenReturn(customer);
        when(this.customerRepository.findByCustomerId(customer.getCustomerId())).thenReturn(Optional.of(customer));

        this.deleteCustomerService.execute(uuid);

        verify(this.customerRepository).delete(customer);
    }

    @Test
    @DisplayName("Should throw exception when customer not found")
    void executeFailure() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerPassword("testpassword123");
        customerDTO.setCustomerName("Test Name");
        
        Customer customer = new Customer();
        customer.setCustomerId(UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a"));

        when(this.customerMapper.map(customerDTO)).thenReturn(customer);
        when(this.customerRepository.findByCustomerId(UUID.fromString("aa3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a"))).thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.deleteCustomerService.execute(UUID.fromString("aa3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a")))
            .isInstanceOf(UserNotFoundException.class);
    }
}
