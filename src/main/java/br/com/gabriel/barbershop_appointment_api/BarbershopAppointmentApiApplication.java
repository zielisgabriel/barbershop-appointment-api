package br.com.gabriel.barbershop_appointment_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BarbershopAppointmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopAppointmentApiApplication.class, args);
	}

}
