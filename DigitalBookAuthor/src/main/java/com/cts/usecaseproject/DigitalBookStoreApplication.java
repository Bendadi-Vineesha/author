package com.cts.usecaseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigitalBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookStoreApplication.class, args);
	}

}
