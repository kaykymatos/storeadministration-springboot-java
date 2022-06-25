package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
