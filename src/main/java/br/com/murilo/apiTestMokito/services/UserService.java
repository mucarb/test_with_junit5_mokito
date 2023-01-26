package br.com.murilo.apiTestMokito.services;

import br.com.murilo.apiTestMokito.domains.User;

public interface UserService {

	User findById(Integer id);
	
}
