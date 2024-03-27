package com.benchmark.todo._core.secret;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class DatabaseSecret {

  private String url = "jdbc:mariadb://localhost:3306/todo";
  private String username = "root";
  private String password = "1234";
}
