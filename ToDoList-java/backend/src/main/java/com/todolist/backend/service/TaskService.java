package com.todolist.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todolist.backend.model.Task;
import com.todolist.backend.model.TaskCategory;
import com.todolist.backend.repo.CategoryRepository;
import com.todolist.backend.repo.TaskRepository;

@Service
public class TaskService {
    
		@Autowired
	   	TaskRepository taskRepo;
		
		@Autowired 
		CategoryRepository catRepo;

		public List<Task> getAllTasks() {
			
			return taskRepo.findAll();
		}
		public ResponseEntity<?> getAllTask(){
//		
			return new ResponseEntity<>("Nothing", HttpStatus.BAD_REQUEST);
		}
		public Task addTask(Task task) {
			
			return taskRepo.save(task);
		}
		
		public Task getTaskById(int taskId) {
			return taskRepo.findById(taskId).orElse(null);
		}
	
		 public Task UpdateTask(Task task , int taskId) {
			 Task tk = taskRepo.findById(taskId).orElse(null);
			 if(tk != null) {
		         tk.setCompleted(true);
				 taskRepo.save(tk);
				 return tk;
				 
			 }
			 return null;
		 }
		 public List<Task> getTaskByCategory( int categoryId){
			 TaskCategory taskCat = catRepo.findById(categoryId).orElse(null);
			 return taskRepo.findBytaskCategory(taskCat);
		 }
}
