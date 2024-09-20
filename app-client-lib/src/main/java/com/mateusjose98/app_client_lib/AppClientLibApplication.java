package com.mateusjose98.app_client_lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mateusjose98.app_client_lib", "com.mateusjose98.shared_lib"})  // Inclui o pacote da lib
public class AppClientLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppClientLibApplication.class, args);
	}

}
