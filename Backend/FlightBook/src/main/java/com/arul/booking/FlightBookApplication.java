package com.arul.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class FlightBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookApplication.class, args);
	}

}
