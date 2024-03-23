package com.benchmark.mvc.dataobject;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TodoByDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @OneToMany
    private List<Todo> todoList;
    @ManyToOne
    private TodoContainer todoContainer;

    public TodoByDate() {
    }

    public TodoByDate(int id, LocalDate date, List<Todo> todoList, TodoContainer todoContainer) {
        this.id = id;
        this.date = date;
        this.todoList = todoList;
        this.todoContainer = todoContainer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public TodoContainer getTodoContainer() {
        return todoContainer;
    }

    public void setTodoContainer(TodoContainer todoContainer) {
        this.todoContainer = todoContainer;
    }
}
