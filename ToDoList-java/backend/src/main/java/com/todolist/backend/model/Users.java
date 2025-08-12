package com.todolist.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    @Override
	public String toString() {
		return "User [id=" + id + ", " + (username != null ? "username=" + username + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (password != null ? "password=" + password : "")
				+ "]";
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
