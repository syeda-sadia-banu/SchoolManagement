package com.SchoolManagementSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.model.Role;
import com.SchoolManagementSystem.model.User;
import com.SchoolManagementSystem.repository.RoleRepsoitory;
import com.SchoolManagementSystem.repository.UserRepository;



@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepsoitory roleRepository;

	public User createUser(User user) {
		if (user.getRoles() == null || user.getRoles().isEmpty()) {
			throw new RuntimeException("user must have at least one role.");
		}

		Set<Role> roles = user.getRoles().stream()
				.map(role -> roleRepository.findByRoleName(role.getRoleName())
						.orElseThrow(() -> new RuntimeException("Role " + role.getRoleName() + " not found")))
				.collect(Collectors.toSet());

		// Set the fetched roles on the user entity
		user.setRoles(roles);

		// Now save the user with the correct roles
		return userRepository.save(user);

	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);

	}

	public List<User> getUserByRole(String roleName) {
		return userRepository.findByRoles_RoleName(roleName);
	}

	public User updateUser(int id, User updatedUser) {
		
		return userRepository.findById(id).map(user -> {
			 System.out.println("Incoming user data: " + updatedUser);
			user.setUserName(updatedUser.getUserName());
			user.setUserEmail(updatedUser.getUserEmail());
			user.setUserPassword(updatedUser.getUserPassword());
			// update user role if provided
			
			System.out.println("Updated User Data: " + updatedUser);

			if (updatedUser.getRoles() != null && !updatedUser.getRoles().isEmpty()) {
				Set<Role> newRoles = updatedUser.getRoles().stream().map(Role::getRoleName)
						.map(roleRepository::findByRoleName).filter(Optional::isPresent).map(Optional::get)
						.collect(Collectors.toSet());
				user.setRoles(newRoles); // Update roles
			}
			return userRepository.save(user);
		}).orElseThrow(() -> new RuntimeException("user not found"));
	}

	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

}
