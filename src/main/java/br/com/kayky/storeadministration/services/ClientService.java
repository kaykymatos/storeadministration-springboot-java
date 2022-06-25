package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.Client;
import br.com.kayky.storeadministration.repository.ClientRepository;
import br.com.kayky.storeadministration.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	public ClientRepository repository;

	public List<Client> getAllClientes() {
		return repository.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Client insertClient(Client obj) {
		return repository.save(obj);
	}

	public Client updateClient(Long id, Client obj) {
		try {
			Client entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void deleteClient(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public void updateData(Client entity, Client obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhoneNumber(obj.getPhoneNumber());
		entity.setAddress(obj.getAddress());
	}
}
