package com.benchmark.todo.todo;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;

  // github ssh key added

  // Get all todos
  // TODO: don't use same method names. Change later (fetch, read, load -> service)
  @GetMapping(path = "")
  public List<TodoDTO.Slim> getAllTodoSlims() {
    return todoService.getAllTodoSlims();
  }

  // Create a to-do
  @PostMapping(path = "")
  @ResponseStatus(HttpStatus.CREATED)
  public void postTodo(@RequestBody TodoDTO.CreateRequest CreateDto) {
    todoService.createTodo(CreateDto);
  }

  // Get to-do by id
  // TODO: combine @CurrentUser
  @GetMapping(path = "/{id}")
  public TodoDTO.Slim getTodoSlimById(@PathVariable long id) {
    return todoService.getTodoSlimById(id);
  }

  // Update to-do by id
  @PatchMapping(path = "/{id}")
  public void updateTodo(@PathVariable long id, @RequestBody TodoDTO.UpdateRequest updateDto) {
    todoService.updateTodo(id, updateDto);
  }

  // Delete to-do by id
  @DeleteMapping(path = "/{id}")
  public void deleteTodo(@PathVariable long id) {
    todoService.deleteTodo(id);
  }

  // Get to-do by date
  @GetMapping(path = "/calendars/{date}")
  public List<TodoDTO.Slim> getTodoByDate(@PathVariable LocalDate date) {
    return todoService.findTodoByDate(date);
  }

  // Get calendar dates
  @GetMapping(path = "/calendars/{month}")
  public List<LocalDate> getTodosInMonth(@PathVariable int month) {
    return todoService.getCalenderDates(month);
  }
}
