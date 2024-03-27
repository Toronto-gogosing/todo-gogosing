package com.benchmark.todo.user.controller;

import com.benchmark.todo.user.dto.AuthDTO;
import com.benchmark.todo.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/sign-in")
  @ResponseStatus(HttpStatus.OK)
  public AuthDTO.SessionToken postSignIn(@RequestBody AuthDTO.SignInRequest dto) {
    return authService.createJsonWebTokens(dto);
  }

  @PostMapping("/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public void postSignUp(@RequestBody AuthDTO.SignUpRequest dto) {
    authService.registerNewUser(dto);
  }
}
