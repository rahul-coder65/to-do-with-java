package com.todolist.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.backend.model.TaskCategory;

@Repository
public interface CategoryRepository extends JpaRepository<TaskCategory, Integer>{
	
}