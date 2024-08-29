package com.webdevelopemnt.SpringWeb.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	@RequestMapping("list-todo")
	public String showTodoList(ModelMap modelMap) {
		List<Todo> todoList=todoService.getAllTodos("Prasanna");
		modelMap.put("todoList", todoList);
		return "todoList";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.addAttribute("todo", todo);
		return "addTodo";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String redirectShowTodoList(ModelMap model, @Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodoList(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = (String)model.get("name");
		todo.setUserName(username);
		todoService.updateTodo(todo);
		return "redirect:list-todo";
	}
	
}
