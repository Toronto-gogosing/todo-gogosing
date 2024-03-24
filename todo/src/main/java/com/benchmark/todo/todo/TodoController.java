package com.benchmark.todo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Get all todos
    @GetMapping(path="/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Create a to-do
    @PostMapping(path="/todos")
    public Todo postTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // Get to-do by date
    @GetMapping(path="/todos/{date}")
    public ResponseEntity<List<Todo>> getTodoByDate(@PathVariable LocalDate date) {
        List<Todo> todoList = todoService.findTodoByDate(date);

        if (todoList.isEmpty()) {
            return new ResponseEntity<>(todoList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(todoList, HttpStatus.CREATED);
    }

    // Delete to-do by id
    @DeleteMapping(path="/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable long id) {
        Optional<Todo> todoOfId = todoService.getTodoById(id);

        if (todoOfId.isPresent()) {
            todoService.deleteTodoById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Update to-do by id
    @PutMapping(path="/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
        Optional<Todo> todoOfId = todoService.getTodoById(id);

        if (todoOfId.isPresent()) {
            todo.setId(id);
            todoService.createTodo(todo);
            return new ResponseEntity<>(todoOfId.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(todoOfId.get(), HttpStatus.BAD_REQUEST);
    }

    // Get calendar dates
    @GetMapping(path="/calendars/{month}")
    public List<LocalDate> getTodosInMonth(@PathVariable int month) {
        return todoService.getCalenderDates(month);
    }
}
