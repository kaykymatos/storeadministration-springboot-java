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

import br.com.kayky.storeadministration.entities.Seller;
import br.com.kayky.storeadministration.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResourse {

	@Autowired
	private SellerService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Seller>> findAll() {

		List<Seller> list = service.getAllSellers();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Seller> findById(@PathVariable Long id) {
		Seller obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Seller> postSeller(@RequestBody Seller Seller) {
		Seller obj = service.insertSeller(Seller);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller obj) {
		obj = service.updateSeller(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Seller> deleteSeller(@PathVariable Long id) {
		service.deleteSeller(id);

		return ResponseEntity.noContent().build();
	}
}
