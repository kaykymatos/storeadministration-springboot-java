package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>  {

}
