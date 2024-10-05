package com.SchoolManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManagementSystem.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByRoles_RoleName(String roleName);

}
