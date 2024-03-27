package com.benchmark.todo._core.config;

import com.benchmark.todo._core.auth.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthenticationEntryPoint customAuthenticationEntryPoint;
  private final AccessDeniedHandler customAccessDeniedHandler;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .headers((config) -> config.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
        .httpBasic(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable);

    http.authorizeHttpRequests((config) -> config
        .requestMatchers("/auth/**").permitAll()
        .anyRequest().authenticated()
    );

    // Ref: https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html#stateless-authentication
    http.sessionManagement((session) ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );

    http.addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class)
        .exceptionHandling((config) ->
            config.authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
        );

    return http.build();
  }

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
