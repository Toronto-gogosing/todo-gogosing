package com.benchmark.mvc.controllers;

import com.benchmark.mvc.repository.TodoRepository;
import com.benchmark.mvc.dataobject.Todo;
import org.springframework.web.bind.annotation.*;


@RestController
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(path="/mvc/todos")
    public String getAllTodos() {
        return "get all todos";
    }

    @PostMapping(path="/mvc/todos")
    public String postTodo(@RequestBody Todo todo) {
        return "add todo";
    }

    @DeleteMapping(path="/mvc/todos/{id}")
    public String deleteTodo(@PathVariable int id) {
        return "delete todo";
    }
}
