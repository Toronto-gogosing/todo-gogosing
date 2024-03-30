package com.benchmark.todo.todo;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  // Get all todos
  @GetMapping(path = "/todos")
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }

  // Create a to-do
  @PostMapping(path = "/todos")
  @ResponseStatus(HttpStatus.CREATED)
  public void postTodo(@RequestBody TodoDTO.CreateRequest dto) {
    todoService.createTodo(dto);
  }

  // Get to-do by date
  @GetMapping(path = "/todos/{date}")
  public ResponseEntity<List<TodoDTO.Detail>> getTodoByDate(@PathVariable LocalDate date) {
    return ResponseEntity.ok(todoService.findTodoByDate(date));
  }

  // Update to-do by id
  @PatchMapping(path = "/todos/{id}")
  public void updateTodo(@PathVariable long id, @RequestBody TodoDTO.UpdateRequest dto) {
    todoService.updateTodo(id, dto);
  }

  // Delete to-do by id
  @DeleteMapping(path = "/todos/{id}")
  public void deleteTodo(@PathVariable long id) {
    todoService.deleteTodo(id);
  }

  // Get calendar dates
  @GetMapping(path = "/calendars/{month}")
  public List<LocalDate> getTodosInMonth(@PathVariable int month) {
    return todoService.getCalenderDates(month);
  }
}
