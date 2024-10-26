package com.punsaeng.pag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PagApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagApplication.class, args);
	}

}