package com.benchmark.todo.todo;

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

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public void createTodo(TodoDTO.CreateRequest dto) {
    todoRepository.save(dto.toEntity());
  }

  public void updateTodo(long id, TodoDTO.UpdateRequest dto) {
    Todo todo = todoRepository.findById(id).orElseThrow(IllegalStateException::new);
    todo.setDueDate(dto.getDueDate());
    todo.setDescription(dto.getDescription());
    todoRepository.save(todo);
  }

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

  public List<TodoDTO.Detail> findTodoByDate(LocalDate date) {
    List<Todo> todos = todoRepository.findAll();

    return todos.stream()
        .filter(todo -> todo.getDueDate().toLocalDate().equals(date))
        .map(TodoDTO.Detail::of)
        .toList();
  }
}
