package com.mateusjose98.app_client_lib;

import com.mateusjose98.shared_lib.security.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mateusjose98.app_client_lib", "com.mateusjose98.shared_lib"})
public class AppClientLibApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppClientLibApplication.class, args);
	}


	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		var user = UsuarioEntity.builder()
				.username("admin")
				.senha(passwordEncoder.encode("123"))
				.role("ADMIN")
				.build();

		em.persist(user);

	}
}
