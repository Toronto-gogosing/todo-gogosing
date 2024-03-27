package com.benchmark.todo.todo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String description;

    public Todo() {
    }

    public Todo(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }
}
