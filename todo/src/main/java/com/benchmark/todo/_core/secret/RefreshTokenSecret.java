package com.benchmark.todo._core.secret;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class RefreshTokenSecret implements TokenSecret {
    private String signingKey = "K+4cNzTdJhnrqFdX8HYO3SuF4LhuuSHSaAGykFBnyuE=";
    private Integer duration = 7200;
}
