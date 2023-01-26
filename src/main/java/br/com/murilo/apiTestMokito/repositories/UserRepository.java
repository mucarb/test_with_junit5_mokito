package br.com.murilo.apiTestMokito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.murilo.apiTestMokito.domains.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
