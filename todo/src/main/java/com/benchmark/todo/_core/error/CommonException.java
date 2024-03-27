package com.benchmark.todo._core.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {
    private final ErrorCode errorCode;

    public static CommonException of(ErrorCode errorCode) {
        return new CommonException(errorCode);
    }
}
