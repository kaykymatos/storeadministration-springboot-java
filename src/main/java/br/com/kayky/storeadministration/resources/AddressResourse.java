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

import br.com.kayky.storeadministration.entities.Address;
import br.com.kayky.storeadministration.services.AddressService;

@RestController
@RequestMapping(value = "/adresses")
public class AddressResourse {

	@Autowired
	private AddressService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Address>> findAllAdresses() {

		List<Address> list = service.getAllAdresses();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Address> findAddressById(@PathVariable Long id) {
		Address obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Address> postAddress(@RequestBody Address Address) {
		Address obj = service.insertAddress(Address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address obj) {
		obj = service.updateAddress(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
		service.deleteAddress(id);

		return ResponseEntity.noContent().build();
	}
}
