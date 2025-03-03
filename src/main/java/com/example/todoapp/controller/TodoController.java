package com.example.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.service.TodoService;

@Controller
@RequestMapping("/todolist")
public class TodoController {
	private final TodoService todoService;

    public TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getTodoList(final Model model) {
        model.addAttribute("todolist", todoService.getAllTodos());
        return "todo-list";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam final String title) {
        todoService.addTodo(title);
        return "redirect:/todolist";
    }
    
    @PostMapping("/delete")
    public String deleteTodo(@RequestParam final long id) {
    	todoService.deleteTodo(id);
    	return "redirect:/todolist";
    }
    
    @PostMapping("/toggle")
    public String toggleTodo(@RequestParam final long id) {
    	todoService.toggleTodo(id);
    	return "redirect:/todolist";
    }
}
