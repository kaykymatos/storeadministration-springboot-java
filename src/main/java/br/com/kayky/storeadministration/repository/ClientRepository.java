package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
