package com.benchmark.todo.user.dto;

import com.benchmark.todo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class Slim {
        private Long id;
        private String name;

        public static Slim of(User user) {
            return Slim.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build();
        }

    }
}
