package com.todolist.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.backend.model.TaskCategory;
import com.todolist.backend.repo.CategoryRepository;

@Service
public class CategoryService {
      
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<TaskCategory> getAllTaskCategory(){
		
		return categoryRepo.findAll();
	}
	
	public TaskCategory addTaskCategory(TaskCategory taskCategory) {
		
		System.out.print(taskCategory);
		categoryRepo.save(taskCategory);
		return taskCategory;
	}
	
	
}
