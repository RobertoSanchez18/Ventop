package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.roberto.sistemaInventario.Productos.model.User;
import pe.edu.roberto.sistemaInventario.Productos.repository.UserRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		User userUpdate = getUserById(id);
		
		userUpdate.setName(user.getName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setEmail(user.getEmail());
		userUpdate.setPhone(user.getPhone());
		userUpdate.setUsername(user.getUsername());
		userUpdate.setPassword(user.getPassword());
		
		return saveUser(userUpdate);
	}

	@Override
	public boolean validateLogin(User user) {
		return userRepository
				.findByUsernameAndPassword(user.getUsername(), user.getPassword())
				.isPresent();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

}
