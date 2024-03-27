package com.benchmark.todo._core.secret;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class DatabaseSecret {
    private String url = "jdbc:mariadb://localhost:3306/todo";
    private String username = "root";
    private String password = "1234";

    void setUrl(String databaseUrl) {
        this.url = this.url == null ? databaseUrl : this.url;
    }

    void setUsername(String username) {
        this.username = this.username == null ? username : this.username;
    }

    void setPassword(String password) {
        this.password = this.password == null ? password : this.password;
    }
}
