package com.teamj.VaccinationSystem;

import com.teamj.VaccinationSystem.Controllers.PatientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class VaccinationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationSystemApplication.class, args);
	}

}
