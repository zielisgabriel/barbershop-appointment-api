package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.exceptions.UserNotFoundException;
import br.com.gabriel.barbershop_appointment_api.services.customer.DeleteCustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeleteCustomerController {
    public final DeleteCustomerService deleteCustomerService;

    @DeleteMapping("/customer/delete/{customerId}")
    public void delete(@PathVariable UUID customerId) throws UserNotFoundException {
        deleteCustomerService.execute(customerId);
    }
}
