package pe.edu.roberto.sistemaInventario.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.roberto.sistemaInventario.Productos.model.User;
import pe.edu.roberto.sistemaInventario.Productos.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServiceImpl.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userServiceImpl.getUserById(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userServiceImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(newUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User userUpdate = userServiceImpl.updateUser(user, id);
		return ResponseEntity.status(HttpStatus.OK).body(userUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
