package pe.edu.roberto.sistemaInventario.Productos.service;

import java.util.List;

import pe.edu.roberto.sistemaInventario.Productos.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	User saveUser(User user);
	
	User updateUser(User user, Long id);
	
	boolean validateLogin(User user);
	
	void deleteUser(Long id);
	
	
	
}
