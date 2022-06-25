package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Seller;
import br.com.kayky.storeadministration.repository.SellerRepository;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {

	@Autowired
	public SellerRepository repository;

	public List<Seller> getAllSellers() {
		return repository.findAll();
	}

	public Seller findById(Long id) {
		Optional<Seller> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Seller updateAddress(Long id, Seller obj) {
		try {
			Seller entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Seller insertSeller(Seller obj) {
		return repository.save(obj);
	}

	public Seller updateSeller(Long id, Seller obj) {
		try {
			Seller entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void deleteSeller(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	private void updateData(Seller entity, Seller obj) {
		entity.setName(obj.getName());
		entity.setFantasyName(obj.getFantasyName());
		entity.setEmail(obj.getEmail());
		entity.setPhoneNumber(obj.getPhoneNumber());
	}

}
