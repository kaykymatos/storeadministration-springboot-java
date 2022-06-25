package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Product;
import br.com.kayky.storeadministration.repository.ProductRepository;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	@Autowired
	public ProductRepository repository;

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insertProduct(Product obj) {
		return repository.save(obj);
	}

	public Product updateProduct(Long id, Product obj) {
		try {
			Product entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void deleteProduct(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public void updateData(Product entity, Product obj) {
		entity.setDescription(obj.getDescription());
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		entity.setCategory(obj.getCategory());
	}
}
