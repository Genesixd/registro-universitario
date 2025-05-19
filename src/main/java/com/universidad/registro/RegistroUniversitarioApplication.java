package com.universidad.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync; // <-- AGREGA ESTO

@SpringBootApplication
@EnableCaching
@EnableAsync // <-- OBLIGATORIO para que funcione @Async
public class RegistroUniversitarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroUniversitarioApplication.class, args);
	}
}
