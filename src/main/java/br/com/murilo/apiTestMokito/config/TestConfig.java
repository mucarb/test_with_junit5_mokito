package br.com.murilo.apiTestMokito.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.murilo.apiTestMokito.domains.User;
import br.com.murilo.apiTestMokito.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;

	@Bean
	void startDB() {
		User u1 = new User(null, "Murilo Ribeiro", "ribeiro@gmail.com", "senha123");
		User u2 = new User(null, "Caio Vinicius", "caio@gmail.com", "senha321");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
