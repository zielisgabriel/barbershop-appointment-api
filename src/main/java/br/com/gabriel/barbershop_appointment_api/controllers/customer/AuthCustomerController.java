package br.com.gabriel.barbershop_appointment_api.controllers.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.barbershop_appointment_api.dtos.AuthCustomerDTO;
import br.com.gabriel.barbershop_appointment_api.services.customer.AuthCustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthCustomerController {
    private final AuthCustomerService authCustomerService;

    @PostMapping("/customer/login")
    public ResponseEntity<String> login(@RequestBody AuthCustomerDTO authCustomerDTO, HttpSession session) {
        this.authCustomerService.execute(authCustomerDTO.getUsername(), authCustomerDTO.getPassword());
        return ResponseEntity.ok().build();
    }
}
