package br.com.gabriel.barbershop_appointment_api.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;


@ActiveProfiles("test")
public class CreateCustomerServiceTest {
    @InjectMocks
    private CreateCustomerService createCustomerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create a new customer")
    void executeSuccess() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerName("Test Name");
        customerDTO.setCustomerPassword("testpassword123");

        Customer customer = this.customerMapper.map(customerDTO);
        
        when(this.customerMapper.map(customerDTO)).thenReturn(customer);
        when(this.customerRepository.save(customer)).thenReturn(customer);

        createCustomerService.execute(customerDTO);

        verify(this.customerRepository).save(customer);
    }

    @Test
    @DisplayName("Should not create a new customer")
    void executeFailure() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerName("Test Name");
        customerDTO.setCustomerPassword("testpassword123");

        when(customerRepository.findByCustomerEmail("testemail@email.com")).thenReturn(Optional.of(new Customer()));

        assertThatThrownBy(() -> this.createCustomerService.execute(customerDTO))
            .isInstanceOf(UserAlreadyExistsException.class);
    }
}
