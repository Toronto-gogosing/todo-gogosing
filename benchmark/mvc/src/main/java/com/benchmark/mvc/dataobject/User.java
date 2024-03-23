package com.benchmark.mvc.dataobject;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String userPassword;
    @OneToOne
    private TodoContainer todoContainer;

    public User() {
    }

    public User(int id, String userName, String userPassword, TodoContainer todoContainer) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.todoContainer = todoContainer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public TodoContainer getTodoContainer() {
        return todoContainer;
    }

    public void setTodoContainer(TodoContainer todoContainer) {
        this.todoContainer = todoContainer;
    }
}
