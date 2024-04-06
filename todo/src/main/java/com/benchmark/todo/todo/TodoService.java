package com.benchmark.todo.todo;

import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo.todo.TodoDTO.Slim;
import com.benchmark.todo.user.entity.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  public List<Todo> fetchAll() {
    return todoRepository.findAll();
  }

  public TodoDTO.Slim fetchTodoSlimById(User user, long id) {

    Todo todo = todoRepository.findById(id).orElseThrow(() ->
        new CommonException(ErrorCode.NOT_FOUND));

    // Is this right way of checking ownership?
    if (!todo.isOwnedBy(user.getId())) {
      throw new CommonException(ErrorCode.UNAUTHORIZED);
    }

    return TodoDTO.Slim.of(todo);
  }

  public List<TodoDTO.Slim> fetchAllTodoSlims(User user) {
    List<Todo> todoList = todoRepository.findAllByUserId(user.getId());

    return todoList
        .stream()
        .map(Slim::of)
        .toList();
  }

  public void createTodo(User user, TodoDTO.CreateRequest createDto) {
    todoRepository.save(createDto.toEntity(user.getId()));
  }

  public void updateTodo(User user, long id, TodoDTO.UpdateRequest updateDto) {

    Todo todo = todoRepository.findById(id).orElseThrow(() ->
        new CommonException(ErrorCode.NOT_FOUND));

    if (!todo.isOwnedBy(user.getId())) {
      throw new CommonException(ErrorCode.UNAUTHORIZED);
    }

    todo.setDueDate(updateDto.getDueDate());
    todo.setDescription(updateDto.getDescription());
    todoRepository.save(todo);
  }

  public void deleteTodo(User user, long id) {
    Todo todo = todoRepository.findById(id).orElseThrow(() ->
        new CommonException(ErrorCode.NOT_FOUND));

    if (!todo.isOwnedBy(user.getId())) {
      throw new CommonException(ErrorCode.UNAUTHORIZED);
    }
    todoRepository.deleteById(id);
  }

  public List<TodoDTO.Slim> fetchTodoByDate(User user, LocalDate date) {

    List<Todo> todos = todoRepository.findAllByDate(user.getId(), date.getYear(), date.getMonthValue(), date.getDayOfMonth());

    return todos.stream()
        .map(TodoDTO.Slim::of)
        .toList();
  }

  public List<Integer> fetchCalenderDates(User user, LocalDate date) {
    return todoRepository.findDatesPresent(user.getId(), date.getYear(), date.getMonthValue());
  }
}
