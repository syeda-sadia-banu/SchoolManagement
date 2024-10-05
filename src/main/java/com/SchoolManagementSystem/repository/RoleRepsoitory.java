package com.SchoolManagementSystem.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SchoolManagementSystem.model.Role;


@Repository
public interface RoleRepsoitory  extends JpaRepository<Role, Integer>{
     
	 Optional<Role> findByRoleName(String roleName);
	

}
