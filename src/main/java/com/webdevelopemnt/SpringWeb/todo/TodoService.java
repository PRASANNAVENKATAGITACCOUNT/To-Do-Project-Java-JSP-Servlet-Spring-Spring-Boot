package com.webdevelopemnt.SpringWeb.todo;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.ArrayList;


@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todoCount=0;
	
	static {
		todos.add(new Todo(++todoCount, "Prasanna", "Learn Java ", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Prasanna", "Learn Kotlin ", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Prasanna", "Learn Spring Spring Boot ", 
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> getAllTodos(String userName){
		Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(++todoCount, username,description,targetDate,isDone);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo-> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
	

}
