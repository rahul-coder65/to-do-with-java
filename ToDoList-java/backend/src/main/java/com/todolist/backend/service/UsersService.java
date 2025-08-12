package com.todolist.backend.service;

import java.util.List;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.todolist.backend.model.Users;
import com.todolist.backend.repo.UserRepo;


@Service
public class UsersService {
   
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder(12);
	
	public Users addUsers(Users user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}

	public String verify(Users user) {
		// TODO Auto-generated method stub
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
         
		if(authentication.isAuthenticated()) {
//			return "Success";
			return jwtService.generateToken(user.getUsername());
		}
		return "Failed";
		
		
	}
//				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
}
