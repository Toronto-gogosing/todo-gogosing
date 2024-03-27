package com.benchmark.todo.user.controller;

import com.benchmark.todo.user.dto.UserDTO;
import com.benchmark.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public UserDTO.Slim getMyInfo() {
    return userService.fetchUser(12L);
  }
}
