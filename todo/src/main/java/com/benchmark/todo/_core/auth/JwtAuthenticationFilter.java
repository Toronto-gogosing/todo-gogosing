package com.benchmark.todo._core.auth;

import com.benchmark.todo._core.auth.provider.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final TokenProvider accessTokenProvider;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain chain
  ) throws ServletException, IOException {
    String token = resolveToken(request);
    if (token != null) {
      SecurityContextHolder.getContext()
          .setAuthentication(accessTokenProvider.loadAuthentication(token));
    }

    chain.doFilter(request, response);
  }

  private String resolveToken(HttpServletRequest request) {
    String authorizationHeader = request.getHeader("Authorization");
    if (!StringUtils.hasText(authorizationHeader)) {
      return null;
    }

    return authorizationHeader.substring(7);
  }
}
