package com.benchmark.todo._core.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorDTO {
    private final String code;
    private final String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    @Builder.Default
    private final List<FieldError> fieldErrors = new ArrayList<>();

    @Builder
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String reason;
        private String value;
    }
}
