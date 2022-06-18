package br.com.kayky.storeadministration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kayky.storeadministration.dto.UserDTO;
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

	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public User insertUser(UserDTO obj) {
		User newUser = new User(null, obj.getName(), obj.getEmail(), obj.getPassword());
		return repository.save(newUser);
	}

	public User updateUser(Integer id, User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	public void deleteUser(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
	}

}
