package com.benchmark.todo._core.auth;

import com.benchmark.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String longId) throws UsernameNotFoundException {
    return userRepository
        .findById(Long.valueOf(longId))
        .orElseThrow(() -> new UsernameNotFoundException(longId));
  }
}
