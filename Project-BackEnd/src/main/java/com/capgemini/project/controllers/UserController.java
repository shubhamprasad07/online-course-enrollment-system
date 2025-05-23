package com.capgemini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.project.entities.User;
import com.capgemini.project.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = service.listAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/count/{userType}")
	public ResponseEntity<Long> getUserCount(@PathVariable("userType") String userType) {
		return ResponseEntity.status(HttpStatus.OK).body(service.userCount(userType));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		User user = service.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saved = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getUserID()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User updated = service.updateUser(id, user);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody User patch) {
		User updated = service.patchUser(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
