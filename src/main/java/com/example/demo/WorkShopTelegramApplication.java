package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class WorkShopTelegramApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();

		SpringApplication.run(WorkShopTelegramApplication.class, args);
	}

}
