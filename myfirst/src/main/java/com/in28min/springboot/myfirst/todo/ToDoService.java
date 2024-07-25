package com.in28min.springboot.myfirst.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<Todo> todos=new ArrayList<>();
	
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount, "aga", "Finish udemy tutorial", LocalDate.now().plusDays(30), false));
		todos.add(new Todo(++todosCount, "aga", "Request new passport so you can go to Ireland", LocalDate.now().plusDays(60), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String desc, LocalDate deadline, boolean isDone) {
		Todo newTodo=new Todo(++todosCount, username, desc, deadline, isDone);
		todos.add(newTodo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
