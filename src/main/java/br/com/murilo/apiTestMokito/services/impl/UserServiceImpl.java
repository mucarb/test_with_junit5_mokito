package br.com.murilo.apiTestMokito.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.apiTestMokito.domains.User;
import br.com.murilo.apiTestMokito.domains.dtos.UserDTO;
import br.com.murilo.apiTestMokito.repositories.UserRepository;
import br.com.murilo.apiTestMokito.services.UserService;
import br.com.murilo.apiTestMokito.services.exceptions.DataIntegrityViolationException;
import br.com.murilo.apiTestMokito.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User create(UserDTO objDTO) {
		findByEmail(objDTO);
		return repository.save(mapper.map(objDTO, User.class));
	}

	@Override
	public User update(UserDTO objDTO) {
		findByEmail(objDTO);
		return repository.save(mapper.map(objDTO, User.class));
	}

	@Override
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private void findByEmail(UserDTO objDTO) {
		Optional<User> user = repository.findByEmail(objDTO.getEmail());

		if (user.isPresent() && !user.get().getId().equals(objDTO.getId())) {
			throw new DataIntegrityViolationException("E-mail já utilizado!");
		}
	}

}
