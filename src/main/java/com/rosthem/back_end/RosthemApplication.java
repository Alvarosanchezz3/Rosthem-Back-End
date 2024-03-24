package com.rosthem.back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RosthemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RosthemApplication.class, args);
	}

}