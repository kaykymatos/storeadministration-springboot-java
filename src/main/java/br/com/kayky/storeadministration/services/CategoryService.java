package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Category;
import br.com.kayky.storeadministration.repository.CategoryRepository;
import br.com.kayky.storeadministration.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository repository;

	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public Category insertCategory(Category obj) {
		return repository.save(obj);
	}

	public void deleteCategory(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
