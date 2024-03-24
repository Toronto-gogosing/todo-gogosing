package com.benchmark.todo.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
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

    public List<Todo> findTodoByDate(LocalDate date) {
        List<Todo> todoList = new ArrayList<>(
                todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getDateTime().toLocalDate().equals(date))
                .toList());

        todoList.sort((t1, t2) -> t1.getDateTime().compareTo(t2.getDateTime()));
        return todoList;
    }
}
