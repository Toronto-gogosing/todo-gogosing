package com.benchmark.mvc.user;

import com.benchmark.mvc.todo.Todo;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Todo> todoList;

    public User() {
    }

    public User(Long id, List<Todo> todoList) {
        this.id = id;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
