package com.todolist.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskCategory {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "TaskCategory [categoryId=" + categoryId + ", "
				+ (categoryName != null ? "categoryName=" + categoryName : "") + "]";
	}
}
