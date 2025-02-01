package com.example.todoapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.model.Todo;

@Controller
@RequestMapping("/todolist")
public class TodoController {
	List<Todo> todolist = new ArrayList<>();
	
	@GetMapping
	public String getTodoList(Model model) {
	    model.addAttribute("todolist", todolist);
	    return "todo-list";
	}
	
	@PostMapping("/add")
    public String addTodo(@RequestParam String title, Model model) {
		Todo newTodo = new Todo(todolist.size() + 1, title, false);
		todolist.add(newTodo);

		model.addAttribute("todolist", todolist);
		return "redirect:/todolist";
	}
}
