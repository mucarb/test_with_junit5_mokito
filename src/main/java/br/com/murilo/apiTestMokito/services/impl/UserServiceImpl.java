package br.com.murilo.apiTestMokito.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.apiTestMokito.domains.User;
import br.com.murilo.apiTestMokito.repositories.UserRepository;
import br.com.murilo.apiTestMokito.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
