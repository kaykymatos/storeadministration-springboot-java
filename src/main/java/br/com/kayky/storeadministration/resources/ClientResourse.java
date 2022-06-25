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

import br.com.kayky.storeadministration.entities.Client;
import br.com.kayky.storeadministration.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResourse {

	@Autowired
	private ClientService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAllClients() {

		List<Client> list = service.getAllClientes();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findClientById(@PathVariable Long id) {
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> postClient(@RequestBody Client Client) {
		Client obj = service.insertClient(Client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client obj) {
		obj = service.updateClient(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
		service.deleteClient(id);

		return ResponseEntity.noContent().build();
	}
}
