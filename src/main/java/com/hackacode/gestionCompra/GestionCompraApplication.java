package com.hackacode.gestionCompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GestionCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCompraApplication.class, args);
	}

}
