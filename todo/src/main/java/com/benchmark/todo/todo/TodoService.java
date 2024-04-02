package com.benchmark.todo.todo;

import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo.todo.TodoDTO.Slim;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  // TODO: delete this code
  public Todo getTodoById(long id) {
    // TODO: fix the exception
    return todoRepository.findById(id).orElseThrow(IllegalStateException::new);
  }

  public TodoDTO.Slim getTodoSlimById(long id) {
    Todo todo = getTodoById(id);
    return TodoDTO.Slim.of(todo);
  }

  public List<TodoDTO.Slim> getAllTodoSlims() {
    List<Todo> todoList = todoRepository.findAll();

    return todoList
        .stream()
        .map(Slim::of)
        .toList();
  }

  public void createTodo(TodoDTO.CreateRequest createDto) {
    todoRepository.save(createDto.toEntity());
  }

  public void updateTodo(long id, TodoDTO.UpdateRequest updateDto) {

    Todo todo = todoRepository.findById(id).orElseThrow(() ->
        new CommonException(ErrorCode.NOT_FOUND));

//    Todo todo = getTodoById(id);
    todo.setDueDate(updateDto.getDueDate());
    todo.setDescription(updateDto.getDescription());
    todoRepository.save(todo);
  }

  // TODO: use custom query
  public List<LocalDate> getCalenderDates(int month) {
    Set<LocalDate> dates = new HashSet<>();
    List<Todo> todoList = new ArrayList<>(
        todoRepository.findAll()
            .stream()
            .filter(todo -> todo.getDueDate().getMonthValue() == month)
            .toList());

    for (Todo todo : todoList) {
      dates.add(todo.getDueDate().toLocalDate());
    }

    List<LocalDate> dateList = new ArrayList<>(dates);
    dateList.sort(LocalDate::compareTo);
    return dateList;
  }

  public void deleteTodo(long id) {
    todoRepository.deleteById(id);
  }

  public List<TodoDTO.Slim> findTodoByDate(LocalDate date) {
    List<Todo> todos = todoRepository.findAll();

    return todos.stream()
        .filter(todo -> todo.getDueDate().toLocalDate().equals(date))
        .map(TodoDTO.Slim::of)
        .toList();
  }
}
