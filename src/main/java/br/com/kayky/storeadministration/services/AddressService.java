package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Address;
import br.com.kayky.storeadministration.repository.AddressRepository;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AddressService {

	@Autowired
	public AddressRepository repository;

	public List<Address> getAllAdresses() {
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Address insertAddress(Address obj) {
		return repository.save(obj);
	}

	public Address updateAddress(Long id, Address obj) {
		try {
			Address entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void deleteAddress(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public void updateData(Address entity, Address obj) {
		entity.setStreet(obj.getStreet());
		entity.setState(obj.getState());
		entity.setHouseNumber(obj.getHouseNumber());
		entity.setReferences(obj.getReferences());
	}
}
