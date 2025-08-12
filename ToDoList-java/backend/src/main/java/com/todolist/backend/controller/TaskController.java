package com.todolist.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.backend.model.Task;
import com.todolist.backend.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class TaskController {
      
	   @Autowired
	   TaskService taskService;
	
	 	@GetMapping("/tasks")
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	    }
	 	
	 	@PostMapping("tasks/add")
	 	public Task addTask(@RequestBody Task task) {
	 		return taskService.addTask(task);
	 	}
	 	
	 	@GetMapping("/task/{taskId}")
	 	public Task getTaskById(@PathVariable int taskId) {
	 		return taskService.getTaskById(taskId);
	 	}
	 	
	 	@PatchMapping("task/update/{taskId}")
	 	public Task UpdateTask(@RequestBody Task task , @PathVariable int taskId) {
	 		
	 		return taskService.UpdateTask(task, taskId);
	 	}
	 	
	 	@GetMapping("/tasks/category/{catId}")
	 	public List<Task> getTaskByCategory(@PathVariable int catId){
	 		return taskService.getTaskByCategory(catId);
	 	}
	 	
	 	@GetMapping("/") 
	 	public String sayHello(HttpServletRequest request ) {
	 		
	 		return "Welcome to spring security topic " + request.getSession().getId();
	 	}
	 	
	 	@GetMapping("/csrf-token")
	 	public CsrfToken getCsrfToken(HttpServletRequest request) {
	 		return (CsrfToken) request.getAttribute("_csrf");
	 	}

}
