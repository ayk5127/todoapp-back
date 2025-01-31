package com.example.todoapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todoapp.model.Todo;

@Controller
@RequestMapping("/todolist")
public class TodoController {
	
	@GetMapping
	public String getTodoList(Model model) {
		List<Todo> todolist = new ArrayList<>();
	    todolist.add(new Todo(1, "買い物をする", false));
	    todolist.add(new Todo(2, "本を読む", true));
	    
	    model.addAttribute("todolist", todolist);
	    return "todo-list";
	}
}
