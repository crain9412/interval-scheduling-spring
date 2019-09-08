package com.jwcrain.hooke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication(exclude = {RepositoryRestMvcAutoConfiguration.class})
public class HookeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HookeApplication.class, args);
	}

}
