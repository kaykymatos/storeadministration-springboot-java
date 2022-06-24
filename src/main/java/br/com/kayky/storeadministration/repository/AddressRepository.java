package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
