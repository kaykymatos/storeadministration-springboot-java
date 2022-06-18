package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.dto.CategoryDTO;
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

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public Category insertCategory(CategoryDTO obj) {
		Category newCategory = new Category(null, obj.getDescription());
		return repository.save(newCategory);
	}

	public Category updateCategory(Integer id, Category obj) {
		Category newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	public void deleteCategory(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
	private void updateData(Category newObj, Category obj) {
		newObj.setDescription(obj.getDescription());
	}
}
