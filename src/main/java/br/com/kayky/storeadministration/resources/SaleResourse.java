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

import br.com.kayky.storeadministration.entities.Sale;
import br.com.kayky.storeadministration.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResourse {

	@Autowired
	private SaleService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sale>> findAllSales() {

		List<Sale> list = service.getAllSales();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sale> findSaleById(@PathVariable Long id) {
		Sale obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sale> postSale(@RequestBody Sale Sale) {
		Sale obj = service.insertSale(Sale);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Sale> deleteSale(@PathVariable Long id) {
		service.deleteSale(id);

		return ResponseEntity.noContent().build();
	}
}
