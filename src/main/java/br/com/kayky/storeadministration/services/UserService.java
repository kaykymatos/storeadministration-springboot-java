package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.entities.User;
import br.com.kayky.storeadministration.repository.UserRepository;
import br.com.kayky.storeadministration.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public User insertUser(User obj) {
		return repository.save(obj);
	}

	public void deleteUser(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
