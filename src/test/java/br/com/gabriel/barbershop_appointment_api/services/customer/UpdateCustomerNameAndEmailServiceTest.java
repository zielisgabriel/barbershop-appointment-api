package br.com.gabriel.barbershop_appointment_api.services.customer;

import static org.assertj.core.api.Assertions.assertThat;
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
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;

@ActiveProfiles("test")
public class UpdateCustomerNameAndEmailServiceTest {
    @InjectMocks
    private UpdateCustomerNameAndEmailService updateCustomerNameAndEmailService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    private void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should update customer name and email")
    public void executeSuccess() {
        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();
        UUID customerUUID = UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a");

        customer.setCustomerId(customerUUID);
        customer.setCustomerName("Old Name");
        customer.setCustomerEmail("oldemail@email.com");

        when(this.customerRepository.findByCustomerId(customerUUID)).thenReturn(Optional.of(customer));
        
        customerDTO.setCustomerName("New Name");
        customerDTO.setCustomerEmail("newemail@email.com");
        
        this.updateCustomerNameAndEmailService.execute(customerUUID, customerDTO);

        assertThat(customer.getCustomerName()).isEqualTo("New Name");
        assertThat(customer.getCustomerEmail()).isEqualTo("newemail@email.com");

        verify(this.customerRepository).save(customer);
    }
}
