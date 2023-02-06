package br.com.murilo.apiTestMokito.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.murilo.apiTestMokito.domains.User;
import br.com.murilo.apiTestMokito.domains.dtos.UserDTO;
import br.com.murilo.apiTestMokito.repositories.UserRepository;
import br.com.murilo.apiTestMokito.services.exceptions.DataIntegratyViolationException;
import br.com.murilo.apiTestMokito.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class UserServiceImplTest {

	private static final Integer ID = 1;
	private static final String NAME = "Murilo";
	private static final String EMAIL = "murilo@gmail.com";
	private static final String PASSWORD = "123";
	private static final String NOT_FOUND_MESSAGE = "Objeto não encontrado!";

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository repository;

	@Mock
	private ModelMapper mapper;

	private User user;
	private UserDTO userDTO;
	private Optional<User> optionalUser;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		when(repository.findById(anyInt())).thenReturn(optionalUser);
		User response = service.findById(ID);
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NAME, response.getName());
		assertEquals(EMAIL, response.getEmail());
	}

	@Test
	void whenFindByIdThenReturnObjectNotoundExceptionTest() {
		when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(NOT_FOUND_MESSAGE));
		
		try {
			service.findById(ID);
		}catch(Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
			assertEquals(NOT_FOUND_MESSAGE, ex.getMessage());
		}
	}

	@Test
	void whenFindAllThenReturnAnListOfUsers() {
		when(repository.findAll()).thenReturn(List.of(user));
		List<User> response = service.findAll();
		assertNotNull(response);
		assertEquals(1, response.size());
	    assertEquals(User.class, response.get(0).getClass());
	    assertEquals(ID, response.get(0).getId());
	    assertEquals(NAME, response.get(0).getName());
	    assertEquals(EMAIL, response.get(0).getEmail());
	    assertEquals(PASSWORD, response.get(0).getPassword());
	}

	@Test
	void whenCreateThenReturnSuccess() {
		when(repository.save(any())).thenReturn(user);
		User response = service.create(userDTO);
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NAME, response.getName());
		assertEquals(EMAIL, response.getEmail());
		assertEquals(PASSWORD, response.getPassword());
	}
	
	@Test
	void whenCreateThenReturnAnDataIntegrityViolationException() {
		when(repository.findByEmail(anyString())).thenReturn(optionalUser);
		
		try {
			optionalUser.get().setId(2);
			service.create(userDTO);
		} catch (Exception ex) {
			assertEquals(DataIntegratyViolationException.class, ex.getClass());
			assertEquals("E-mail já utilizado!", ex.getMessage());
		}
	}

	@Test
	void whenUpdateThenReturnSuccess() {
		when(repository.save(any())).thenReturn(user);
		User response = service.update(userDTO);
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NAME, response.getName());
		assertEquals(EMAIL, response.getEmail());
		assertEquals(PASSWORD, response.getPassword());
	}

	@Test
	void whenUpdateThenReturnAnDataIntegrityViolationException() {
		when(repository.findByEmail(anyString())).thenReturn(optionalUser);
		
		try {
			optionalUser.get().setId(2);
			service.update(userDTO);
		} catch (Exception ex) {
			assertEquals(DataIntegratyViolationException.class, ex.getClass());
			assertEquals("E-mail já utilizado!", ex.getMessage());
		}
	}
	
	@Test
	void testDelete() {
	}

	private void startUser() {
		user = new User(ID, NAME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
		optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
	}

}
