package com.todolist.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.backend.model.Task;
import com.todolist.backend.model.TaskCategory;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findBytaskCategory(TaskCategory taskCat);

}


