package com.benchmark.todo.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void updateTodo(long id, TodoDTO.UpdateRequest dto) {
        Todo todo = todoRepository.findById(id).orElseThrow(IllegalStateException::new);
        todoRepository.save(todo);
        // 204 No content
        // 201 Created
    }


    public void createTodo(TodoDTO.CreateRequest dto) {
        todoRepository.save(dto.toEntity());
    }

    public List<LocalDate> getCalenderDates(int month) {
        Set<LocalDate> dates = new HashSet<>();
        List<Todo> todoList = new ArrayList<>(
                todoRepository.findAll()
                        .stream()
                        .filter(todo -> todo.getDateTime().getMonthValue() == month)
                        .toList());

        for (Todo todo : todoList) {
            dates.add(todo.getDateTime().toLocalDate());
        }

        List<LocalDate> dateList = new ArrayList<>(dates);
        dateList.sort(LocalDate::compareTo);
        return dateList;
    }

    public void deleteTodoById(long id) {
        todoRepository.deleteById(id);
    }

    public List<TodoDTO.Detail> findTodoByDate(LocalDate date) {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream()
                .filter(todo -> todo.getDateTime().toLocalDate().equals(date))
                .map(TodoDTO.Detail::of)
                .toList();
    }
}
