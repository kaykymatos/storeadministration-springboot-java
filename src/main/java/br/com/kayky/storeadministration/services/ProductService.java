package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Product;
import br.com.kayky.storeadministration.repository.ProductRepository;
import br.com.kayky.storeadministration.services.exception.ObjectNotFoundException;

@Service
public class ProductService {
	@Autowired
	public ProductRepository repository;

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public Product insertProduct(Product obj) {
		return repository.save(obj);
	}

	public void deleteProduct(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
