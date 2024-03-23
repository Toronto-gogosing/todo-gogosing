package com.benchmark.mvc.dataobject;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateTime;
    private String description;
    @ManyToOne
    private TodoByDate todoByDate;

    public Todo() {
    }

    public Todo(int id, LocalDateTime dateTime, String description, TodoByDate todoByDate) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.todoByDate = todoByDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoByDate getTodoByDate() {
        return todoByDate;
    }

    public void setTodoByDate(TodoByDate todoByDate) {
        this.todoByDate = todoByDate;
    }
}
