package br.com.murilo.apiTestMokito.services;

import java.util.List;

import br.com.murilo.apiTestMokito.domains.User;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();
	
}
