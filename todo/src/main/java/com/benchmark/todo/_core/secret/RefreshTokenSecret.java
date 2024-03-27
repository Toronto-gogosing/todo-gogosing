package com.benchmark.todo._core.secret;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RefreshTokenSecret implements TokenSecret {
    private String signingKey = "K+4cNzTdJhnrqFdX8HYO3SuF4LhuuSHSaAGykFBnyuE=";
    private Integer duration = 7200;

    public void setSigningKey(String signingKey) {
        this.signingKey = this.signingKey == null ? signingKey: this.signingKey;
    }

    public void setDuration(int duration) {
        this.duration = this.duration == null ? duration : this.duration;
    }
}
