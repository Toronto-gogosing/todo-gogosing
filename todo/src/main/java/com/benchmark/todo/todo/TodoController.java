package com.benchmark.todo.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // Get all todos
    @GetMapping(path="/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Create a to-do
    @PostMapping(path="/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public void postTodo(@RequestBody TodoDTO.CreateRequest dto) {
        todoService.createTodo(dto);
    }

    // Get to-do by date
    @GetMapping(path="/todos/{date}")
    public ResponseEntity<List<TodoDTO.Detail>> getTodoByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(todoService.findTodoByDate(date));
    }

    // Delete to-do by id
//    @DeleteMapping(path="/todos/{id}")
//    public void deleteTodo(@PathVariable long id) {
//        Optional<Todo> todoOfId = todoService.getTodoById(id);
//
//        if (todoOfId.isPresent()) {
//            todoService.deleteTodoById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    // Update to-do by id
//    @PutMapping(path="/todos/{id}")
//    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody TodoDTO.UpdateRequest dto) {
//        return new ResponseEntity<>(todoService.updateTodo(id, dto));
//    }

    // Get calendar dates
    @GetMapping(path="/calendars/{month}")
    public List<LocalDate> getTodosInMonth(@PathVariable int month) {
        return todoService.getCalenderDates(month);
    }
}
