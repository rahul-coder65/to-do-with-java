package com.todolist.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	private boolean completed = false;
	


	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime time;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private TaskCategory taskCategory;

	public int getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public boolean isCompleted() {
		return completed;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public TaskCategory getTaskCategory() {
		return taskCategory;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setTaskCategory(TaskCategory taskCategory) {
		this.taskCategory = taskCategory;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", " + (taskName != null ? "taskName=" + taskName + ", " : "") + "completed="
				+ completed + ", " + (date != null ? "date=" + date + ", " : "")
				+ (time != null ? "time=" + time + ", " : "")
				+ (taskCategory != null ? "taskCategory=" + taskCategory : "") + "]";
	}
	
	
}
