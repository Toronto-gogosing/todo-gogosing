package com.benchmark.todo._core.secret;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class AccessTokenSecret implements TokenSecret {
    private String signingKey = "9KOzHKKK/KjZIjlWEveqMwBplQHCCwRd2jEHMsbBLO8=";
    private Integer duration = 3600;
}
