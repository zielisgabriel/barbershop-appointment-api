package br.com.gabriel.barbershop_appointment_api.services.customer;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.domain.Customer;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerDTO;
import br.com.gabriel.barbershop_appointment_api.exceptions.UserAlreadyExistsException;
import br.com.gabriel.barbershop_appointment_api.mappers.CustomerMapper;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;

@ActiveProfiles("test")
public class CreateCustomerServiceTest {
    @InjectMocks
    private CreateCustomerService createCustomerService;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create a new customer")
    void executeSuccess() {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = new Customer();

        customerDTO.setCustomerEmail("testemail@email.com");
        customerDTO.setCustomerName("Test Name");
        customerDTO.setCustomerPassword("testpassword123");

        when(this.customerMapper.map(customerDTO)).thenReturn(customer);
        this.createCustomerService.execute(customerDTO);

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
