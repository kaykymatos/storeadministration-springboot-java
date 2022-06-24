package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
