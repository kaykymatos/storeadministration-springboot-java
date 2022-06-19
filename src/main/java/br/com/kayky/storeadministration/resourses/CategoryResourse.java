package br.com.kayky.storeadministration.resourses;

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

import br.com.kayky.storeadministration.entities.Category;
import br.com.kayky.storeadministration.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResourse {

	@Autowired
	private CategoryService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll() {

		List<Category> list = service.getAllCategories();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Category> postCategory(@RequestBody Category Category) {
		Category obj = service.insertCategory(Category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
		service.deleteCategory(id);

		return ResponseEntity.noContent().build();
	}
}
