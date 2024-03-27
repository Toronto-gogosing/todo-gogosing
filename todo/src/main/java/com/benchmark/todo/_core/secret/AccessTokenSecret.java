package com.benchmark.todo._core.secret;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class AccessTokenSecret implements TokenSecret {

  private String signingKey = "909d03e12ce624d5e69085e6ba3e1b83";
  private Integer duration = 3600;
}
