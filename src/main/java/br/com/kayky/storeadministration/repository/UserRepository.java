package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
