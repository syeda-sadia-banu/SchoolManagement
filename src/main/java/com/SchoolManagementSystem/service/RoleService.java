package com.SchoolManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.model.Role;
import com.SchoolManagementSystem.repository.RoleRepsoitory;

@Service
public class RoleService {
	@Autowired
	private RoleRepsoitory repo;

	public Role add(Role role) {
		return repo.save(role);

	}

}
