package com.benchmark.todo.todo;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class TodoDTO {
    public static class CreateRequest {
        LocalDateTime datetime;
        @NotBlank
        @Length(max = 50)
        String description;

        public Todo toEntity() {
            return new Todo(
                    datetime,
                    description
            );
        }
    }

    public static class UpdateRequest {
        Long id;
        LocalDateTime datetime;
        String description;
    }

    // 단건 조회
    // todos/{id}
    @Builder
    public static class Detail {
        Long id;
        LocalDateTime datetime;
        String description;

        public static Detail of(Todo todo) {
            return Detail.builder()
                    .id(todo.getId())
                    .datetime(todo.getDateTime())
                    .description(todo.getDescription())
                    .build();
        }
    }
}
