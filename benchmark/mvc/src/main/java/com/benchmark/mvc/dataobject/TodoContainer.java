package com.benchmark.mvc.dataobject;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TodoContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<TodoByDate> todoByDateList;

    public TodoContainer() {
    }

    public TodoContainer(int id, List<TodoByDate> todoByDateList) {
        this.id = id;
        this.todoByDateList = todoByDateList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TodoByDate> getTodoByDateList() {
        return todoByDateList;
    }

    public void setTodoByDateList(List<TodoByDate> todoByDateList) {
        this.todoByDateList = todoByDateList;
    }
}
