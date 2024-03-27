package com.benchmark.todo._core.handler;

import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo._core.error.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorDTO> handleAuthenticationException() {
        ErrorCode errorCode = ErrorCode.FORBIDDEN;
        return ResponseEntity.status(errorCode.getStatus()).body(errorCode.toErrorDTO());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException() {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;
        return ResponseEntity.status(errorCode.getStatus()).body(errorCode.toErrorDTO());
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDTO> handleCommonException(CommonException e) {
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(e.getErrorCode().toErrorDTO());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleUnknownException() {
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;
        return ResponseEntity.status(errorCode.getStatus()).body(errorCode.toErrorDTO());
    }
}
