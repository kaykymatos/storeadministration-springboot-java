package br.com.kayky.storeadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kayky.storeadministration.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
