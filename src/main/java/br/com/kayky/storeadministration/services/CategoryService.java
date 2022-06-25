package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Category;
import br.com.kayky.storeadministration.repository.CategoryRepository;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository repository;

	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category updateCategory(Long id, Category obj) {
		try {
			Category entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Category insertCategory(Category obj) {
		return repository.save(obj);
	}

	public void deleteCategory(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public void updateData(Category entity, Category obj) {
		entity.setDescription(obj.getDescription());
	}
}
