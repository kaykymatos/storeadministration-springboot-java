package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Sale;
import br.com.kayky.storeadministration.entities.Seller;
import br.com.kayky.storeadministration.repository.ProductRepository;
import br.com.kayky.storeadministration.repository.SaleRepository;
import br.com.kayky.storeadministration.repository.SellerRepository;
import br.com.kayky.storeadministration.services.exception.DatabaseException;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;

@Service
public class SaleService {
	@Autowired
	public SaleRepository repository;
	@Autowired
	public ProductRepository prodRepository;

	@Autowired
	public SellerRepository sellerRepository;

	public List<Sale> getAllSales() {
		return repository.findAll();
	}

	public Sale findById(Long id) {
		Optional<Sale> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Sale insertSale(Sale obj) {
		double qunt = prodRepository.getReferenceById(obj.getProduct().getId()).getStockQuantity();
		Seller seller = sellerRepository.getReferenceById(obj.getSeller().getId());
		
		if(obj.getQuantity()> qunt)
			throw new DatabaseException("Quantity in stock insufficient");
		
		if(seller != obj.getSeller())
			throw new DatabaseException("Seller not foud");
			
		obj = new Sale(obj);
		return repository.save(obj);
	}

	public void deleteSale(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
