package com.benchmark.todo._core.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ErrorCode { // @formatter:off
    /* COMMON */
    BAD_REQUEST            ("COM-000", 400, null),
    UNAUTHORIZED           ("COM-001", 401, null),
    FORBIDDEN              ("COM-002", 403, null),
    NOT_FOUND              ("COM-003", 404, null),
    CONFLICT               ("COM-004", 409, null),
    VALIDATION_ERROR       ("COM-005", 412, null),
    SERVER_ERROR           ("COM-006", 500, null),

    /* USER */

    ; /* END OF ERROR CODE */
    private final String code;
    private final int status;
    private final String message;

    public ErrorDTO toErrorDTO() {
        return ErrorDTO.builder().code(this.getCode()).message(this.getMessage()).build();
    }
}
