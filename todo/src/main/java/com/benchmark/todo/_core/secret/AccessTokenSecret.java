package com.benchmark.todo._core.secret;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AccessTokenSecret implements TokenSecret {
    private String signingKey = "9KOzHKKK/KjZIjlWEveqMwBplQHCCwRd2jEHMsbBLO8=";
    private Integer duration = 3600;

    public void setSigningKey(String signingKey) {
        this.signingKey = this.signingKey == null ? signingKey : this.signingKey;
    }

    public void setDuration(int duration) {
        this.duration = this.duration == null ? duration : this.duration;
    }
}
