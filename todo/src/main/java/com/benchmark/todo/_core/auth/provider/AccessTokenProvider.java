package com.benchmark.todo._core.auth.provider;

import com.benchmark.todo._core.secret.TokenSecret;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccessTokenProvider extends TokenProvider {

  private final TokenSecret accessTokenSecret;
  private final UserDetailsService userDetailsService;

  @Override
  protected TokenSecret getSecret() {
    return accessTokenSecret;
  }

  @Override
  protected UserDetailsService getUserDetailsService() {
    return userDetailsService;
  }

//    public AccessTokenProvider(String secret, Integer duration, UserDetailsService userDetailsService) {
//        this.secret = secret;
//        this.duration = duration;
//        this.userDetailsService = userDetailsService;
//    }
}
