package com.benchmark.todo._core.auth.provider;

import com.benchmark.todo._core.secret.TokenSecret;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenProvider extends TokenProvider{
    private final TokenSecret refreshTokenSecret;
    private final UserDetailsService userDetailsService;

    @Override
    protected TokenSecret getSecret() {
        return refreshTokenSecret;
    }

    @Override
    protected UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
}
