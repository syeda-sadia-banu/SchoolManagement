package com.SchoolManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagementSystem.model.User;
import com.SchoolManagementSystem.service.UsersService;


@RestController
public class UserController {

	@Autowired
	private UsersService service;
    
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(service.createUser(user));

	}
    
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserByRole(@RequestParam String role) {
		return ResponseEntity.ok(service.getUserByRole(role));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getUsers(User user) {
		return ResponseEntity.ok(service.getAllUser());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		System.out.println("Incoming user data: " + user);
		return ResponseEntity.ok(service.updateUser(id, user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {

		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
