package br.com.gabriel.barbershop_appointment_api.services.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import br.com.gabriel.barbershop_appointment_api.models.Customer;
import br.com.gabriel.barbershop_appointment_api.repositories.CustomerRepository;

@ActiveProfiles("test")
public class ListCustomersServiceTest {
    @InjectMocks
    private ListCustomersService listCustomersService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should list all customers")
    public void executeSuccess() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setCustomerId(UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a"));
        customer1.setCustomerEmail("testemail1@email.com");
        customer1.setCustomerPassword("test1password123");
        customer1.setCustomerName("Test Name 1");

        customer2.setCustomerId(UUID.fromString("4a4a4a4a-4a4a-4a4a-4a4a-4a4a4a4a4a4a"));
        customer2.setCustomerEmail("testemail2@email.com");
        customer2.setCustomerPassword("test2password123");
        customer2.setCustomerName("Test Name 2");

        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerRepository.findAll()).thenReturn(customers);
        
        assertThat(this.listCustomersService.execute()).hasSize(2);
        assertThat(this.listCustomersService.execute().get(0).getCustomerId())
            .isEqualTo(UUID.fromString("3a3a3a3a-3a3a-3a3a-3a3a-3a3a3a3a3a3a"));
        assertThat(this.listCustomersService.execute().get(0).getCustomerName())
            .isEqualTo("Test Name 1");
        assertThat(this.listCustomersService.execute().get(1).getCustomerId())
            .isEqualTo(UUID.fromString("4a4a4a4a-4a4a-4a4a-4a4a-4a4a4a4a4a4a"));
        assertThat(this.listCustomersService.execute().get(1).getCustomerName())
            .isEqualTo("Test Name 2");
    }
}
