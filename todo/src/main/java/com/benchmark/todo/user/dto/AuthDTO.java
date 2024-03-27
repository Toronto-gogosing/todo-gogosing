package com.benchmark.todo.user.dto;

import com.benchmark.todo.user.entity.User;
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

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .name(name)
                    .build();
        }

    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class SessionToken {
        private String accessToken;
        private String refreshToken;
    }
}
