package com.eduardo.prueba.kosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.eduardo.prueba.kosmos.app.domain.repository")
public class KosmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(KosmosApplication.class, args);
	}

}
