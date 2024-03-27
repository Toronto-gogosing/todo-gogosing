package com.benchmark.todo._core.secret;

public interface TokenSecret {
    String getSigningKey();
    Integer getDuration();
}
