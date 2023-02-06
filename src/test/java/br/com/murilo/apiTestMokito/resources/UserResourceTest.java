package br.com.murilo.apiTestMokito.resources;

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
import br.com.murilo.apiTestMokito.services.UserService;

@SpringBootTest
class UserResourceTest {

	private static final Integer ID = 1;
	private static final String NAME = "Murilo";
	private static final String EMAIL = "murilo@gmail.com";
	private static final String PASSWORD = "123";

	@InjectMocks
	private UserResource resource;

	@Mock
	private UserService service;

	@Mock
	private ModelMapper mapper;

	private User user;
	private UserDTO userDTO;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void testFindById() {
	}

	@Test
	void testFindAll() {
	}

	@Test
	void testCreate() {
	}

	@Test
	void testUpdate() {
	}

	@Test
	void testDelete() {
	}

	private void startUser() {
		user = new User(ID, NAME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
	}

}
