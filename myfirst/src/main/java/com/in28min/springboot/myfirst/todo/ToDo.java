package com.in28min.springboot.myfirst.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class ToDo {
	private int id;
	private String username;
	@Size(min=10, message="Cannot be shorter than 10 characters")
	private String description;
	private LocalDate deadline;
	private boolean done;
	
	public ToDo(int id, String username, String description, LocalDate deadline, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.deadline = deadline;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDateline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", deadline=" + deadline
				+ ", done=" + done + "]";
	}

}
