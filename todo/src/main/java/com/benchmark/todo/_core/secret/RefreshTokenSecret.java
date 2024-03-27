package com.benchmark.todo._core.secret;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class RefreshTokenSecret implements TokenSecret {

  private String signingKey = "34db70810ae7c49abc39d53cefbf84ba";
  private Integer duration = 7200;
}
