package com.todolist.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.backend.model.UserPrincipal;
import com.todolist.backend.model.Users;
import com.todolist.backend.repo.UserRepo;

@Service
public class MyUserDetailsServices implements UserDetailsService{ 
	
	@Autowired
	private UserRepo repo;
      
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}
}
