package com.example.todoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.todoapp.model.Todo;

@Service
public class TodoService {
	private final List<Todo> todolist = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Todo> getAllTodos() {
        return todolist;
    }

    public void addTodo(final String title) {
        Todo newTodo = new Todo(idGenerator.getAndIncrement(), title, false);
        todolist.add(newTodo);
    }
    
    public void deleteTodo(final long id) {
    	todolist.removeIf(todo -> todo.getId() == id);
    }
    
    public void toggleTodo(final long id) {
    	for (Todo todo : todolist) {
    		if (todo.getId() == id) {
    			todo.setCompleted(!todo.getCompleted());
    			break;
    		}
    	}
    }
	
}
