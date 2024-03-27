package com.benchmark.todo._core.secret;

public interface TokenSecret {
    String getSigningKey();
    Integer getDuration();
    void setSigningKey(String signingKey);
    void setDuration(int duration);
}
