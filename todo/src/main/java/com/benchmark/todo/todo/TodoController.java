package com.benchmark.todo.todo;

import com.benchmark.todo._core.auth.argumentresolver.CurrentUser;
import com.benchmark.todo.user.entity.User;
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

  // Get all todos
  // just for testing
  @GetMapping(path = "/all")
  public List<Todo> getAll() {
    return todoService.fetchAll();
  }

  // Get all todos of user
  @GetMapping(path = "")
  public List<TodoDTO.Slim> getAllTodoSlims(@CurrentUser User user) {
    return todoService.fetchAllTodoSlims(user);
  }

  // Create a to-do
  @PostMapping(path = "")
  @ResponseStatus(HttpStatus.CREATED)
  public void postTodo(@CurrentUser User user, @RequestBody TodoDTO.CreateRequest CreateDto) {
    todoService.createTodo(user, CreateDto);
  }

  // Get to-do by id
  // Todo: verify that to-do belongs to the user
  @GetMapping(path = "/{id}")
  public TodoDTO.Slim getTodoSlimById(@CurrentUser User user, @PathVariable long id) {
    return todoService.fetchTodoSlimById(user, id);
  }

  // Update to-do by id
  @PatchMapping(path = "/{id}")
  public void updateTodo(@CurrentUser User user, @PathVariable long id,
      @RequestBody TodoDTO.UpdateRequest updateDto) {
    todoService.updateTodo(user, id, updateDto);
  }

  // Delete to-do by id
  @DeleteMapping(path = "/{id}")
  public void deleteTodo(@CurrentUser User user, @PathVariable long id) {
    todoService.deleteTodo(user, id);
  }

  // Get to-do by date
  @GetMapping(path = "/calendar-date/{date}")
  public List<TodoDTO.Slim> getTodoByDate(@CurrentUser User user, @PathVariable("date") String date) {
    return todoService.fetchTodoByDate(user, date);
  }

  // Get calendar dates of a month
  @GetMapping(path = "/calendar-month/{date}")
  public List<Integer> getTodosInMonth(@CurrentUser User user, @PathVariable("date") String date) {
    return todoService.fetchCalenderDates(user, date);
  }
}
