package com.universidad.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class RegistroUniversitarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroUniversitarioApplication.class, args);
	}

}
