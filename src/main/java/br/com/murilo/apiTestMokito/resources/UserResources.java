package br.com.murilo.apiTestMokito.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.apiTestMokito.domains.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(new User(1, "Marcio", "marcio@gmail.com", "senha123"));
	}

}
