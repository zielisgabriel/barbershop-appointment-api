package br.com.gabriel.barbershop_appointment_api.services.customer_haircut;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import br.com.gabriel.barbershop_appointment_api.domain.Customer_HairCut;
import br.com.gabriel.barbershop_appointment_api.dtos.CustomerResponseDTO;
import br.com.gabriel.barbershop_appointment_api.dtos.Customer_HairCutResponseDTO;
import br.com.gabriel.barbershop_appointment_api.repositories.Customer_HairCutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListCustomer_HairCutService {
    private final Customer_HairCutRepository customer_HairCutRepository;

    public List<Customer_HairCutResponseDTO> execute() {
        List<Customer_HairCut> customer_HairCuts = this.customer_HairCutRepository.findAll(Sort.by(Sort.Direction.ASC, "appointmentDateTime"));
        List<Customer_HairCutResponseDTO> customer_HairCutsModified = new ArrayList<Customer_HairCutResponseDTO>(); // TODO: renomear variável

        customer_HairCuts.forEach(customerHairCut -> {
            Customer_HairCutResponseDTO customerHairCutResponseDTO = new Customer_HairCutResponseDTO();
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO(customerHairCut.getCustomer().getCustomerId(), customerHairCut.getCustomer().getCustomerName());

            customerHairCutResponseDTO.setCustomerHaircutId(customerHairCut.getCustomerHaircutId());
            customerHairCutResponseDTO.setCustomer(customerResponseDTO);
            customerHairCutResponseDTO.setAppointmentDateTime(customerHairCut.getAppointmentDateTime());
            customerHairCutResponseDTO.setHairCut(customerHairCut.getHaircut());

            customer_HairCutsModified.add(customerHairCutResponseDTO);
        });

        return customer_HairCutsModified;
    }
}
