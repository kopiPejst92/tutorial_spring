package com.in28min.springboot.myfirst.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService todoService;
		
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}


	 @RequestMapping("all-todos")
	public String listAllTodos(ModelMap model) {
		 List<ToDo> todos=todoService.findByUsername("aga");
		 model.addAttribute("todos", todos);
		 return "listTodos";
	}

	 @RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		 String username= (String)model.get("name");
		 ToDo todo=new ToDo(100,username, "", LocalDate.now().plusYears(1), false);
		 model.put("todo", todo);
		 return "todo";
	}
	 
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		if(result.hasErrors()) {
			model.put(BindingResult.class.getName() + ".todo", result);
			return "todo";
		}
		String username= (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getDeadline(), false);
		return "redirect:all-todos";
	}
	
	 @RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		 todoService.deleteById(id);
		 return "redirect:all-todos";
	}
	 
	 @RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		 ToDo todo=todoService.findById(id);
		 model.addAttribute("todo", todo);
		 return "todo";
	}
	 
		@RequestMapping(value="update-todo", method=RequestMethod.POST)
		public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
			if(result.hasErrors()) {
				model.put(BindingResult.class.getName() + ".todo", result);
				return "todo";
			}
			String username= (String)model.get("name");
			todo.setUsername(username);
			todoService.updateToDo(todo);
			return "redirect:all-todos";
		}
	
}
