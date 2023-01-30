package br.com.murilo.apiTestMokito.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappperConfig {

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
