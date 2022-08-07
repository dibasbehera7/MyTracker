package com.dibasb.mytracker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dibasb.mytracker.entities.Todo;
import com.dibasb.mytracker.repository.TodoRepository;

@Controller
public class TodoController {

	@Autowired
	TodoRepository repository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		/*
		 * binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
		 * 
		 * @Override public void setAsText(String text) throws IllegalArgumentException
		 * { LocalDate.parse(text, DateTimeFormatter.ISO_DATE); }
		 * 
		 * @Override public String getAsText() { return this.getValue().toString(); }
		 * });
		 */
	}

	@GetMapping("/list-todos")
	public String showTodos(ModelMap model, Authentication auth) {
		String name = auth.getName();
		model.put("todos", repository.findByUser(name));
		// model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	@GetMapping("/add-todo")
	public String showAddTodoPage(ModelMap model, Authentication auth) {
		model.addAttribute("todo", new Todo(0, auth.getName(), "Default Desc", new Date(), false));
		return "todo";
	}

	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		repository.deleteById(id);
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = repository.findById(id).get();
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, Authentication auth, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(auth.getName());
		repository.save(todo);
		return "redirect:/list-todos";
	}

	@PostMapping("/add-todo")
	public String addTodo(ModelMap model, Authentication auth, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(auth.getName());
		repository.save(todo);
		return "redirect:/list-todos";
	}

}
