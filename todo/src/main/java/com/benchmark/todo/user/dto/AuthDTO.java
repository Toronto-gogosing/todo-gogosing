package com.benchmark.todo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class AuthDTO {

  @Getter
  @AllArgsConstructor
  public static class SignInRequest {

    private String username;
    private String password;
  }

  @Getter
  @AllArgsConstructor
  public static class SignUpRequest {

    private String username;
    private String password;
    private String name;
  }

  @Getter
  @AllArgsConstructor
  @Builder
  public static class SessionToken {

    private String accessToken;
    private String refreshToken;
  }
}
