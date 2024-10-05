package com.SchoolManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagementSystem.model.Role;
import com.SchoolManagementSystem.service.RoleService;


@RestController
public class RoleController {
	
	@Autowired
	private RoleService service;
	@PostMapping("/addRole")
	public String addRole(@RequestBody Role role){
		
		service.add(role);
		return "added";
	}
	

}
