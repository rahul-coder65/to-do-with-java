package com.todolist.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.backend.model.Users;
import com.todolist.backend.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
     
	@Autowired
    private UsersService userService; 
	
	@PostMapping("/login")
	public String userLogin(@RequestBody Users user) {
		return userService.verify(user);
	}
	
	@PostMapping("/register")
	public Users addUsers(@RequestBody Users user) {
		return userService.addUsers(user);
	}
	
	@GetMapping("/list") 
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
}
