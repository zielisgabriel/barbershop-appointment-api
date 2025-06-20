package br.com.gabriel.barbershop_appointment_api.services.customer_haircut;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gabriel.barbershop_appointment_api.exceptions.CustomerHairCutNotFoundException;
import br.com.gabriel.barbershop_appointment_api.models.Customer_HairCut;
import br.com.gabriel.barbershop_appointment_api.repositories.Customer_HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCustomer_HairCutService {
    private final Customer_HairCutRepository customer_HairCutRepository;

    public void execute(UUID customerHaircutId) {
        Customer_HairCut customer_HairCut = this.customer_HairCutRepository
            .findByCustomerHaircutId(customerHaircutId)
            .orElseThrow(() -> new CustomerHairCutNotFoundException());

        this.customer_HairCutRepository.delete(customer_HairCut);
    }
}
