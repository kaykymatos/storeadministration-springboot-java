package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.dto.ProductDTO;
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

	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public Product insertProduct(ProductDTO obj) {
		Product newProduct = new Product(null, obj.getName(), obj.getDescription(), obj.getPrice(), obj.getCategory());
		return repository.save(newProduct);
	}

	public Product updateProduct(Integer id, Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	public void deleteProduct(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
	}
}
