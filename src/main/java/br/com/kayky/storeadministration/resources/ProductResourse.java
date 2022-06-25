package br.com.kayky.storeadministration.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.kayky.storeadministration.entities.Product;
import br.com.kayky.storeadministration.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResourse {

	@Autowired
	private ProductService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> list = service.getAllProducts();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> postProduct(@RequestBody Product Product) {
		Product obj = service.insertProduct(Product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product obj) {
		obj = service.updateProduct(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);

		return ResponseEntity.noContent().build();
	}
}
