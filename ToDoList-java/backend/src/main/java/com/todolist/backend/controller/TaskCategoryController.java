package com.todolist.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.backend.model.TaskCategory;
import com.todolist.backend.service.CategoryService;

@RestController
public class TaskCategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<TaskCategory> getAllTaskCategory(){
		return categoryService.getAllTaskCategory();
	}
	
	@PostMapping("categories/add")
	public TaskCategory addTaskCategory(@RequestBody TaskCategory taskCategory) {
		System.out.println("In Controller" + taskCategory);
		return categoryService.addTaskCategory(taskCategory);
	}
}
