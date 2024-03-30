package com.benchmark.todo.user.service;

import com.benchmark.todo._core.auth.provider.TokenProvider;
import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo.user.dto.AuthDTO;
import com.benchmark.todo.user.entity.User;
import com.benchmark.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final TokenProvider accessTokenProvider;
  private final TokenProvider refreshTokenProvider;
  private final PasswordEncoder passwordEncoder;

  public AuthDTO.SessionToken createJsonWebTokens(AuthDTO.SignInRequest dto) {
    User user = userRepository.findByUsername(dto.getUsername())
        .orElseThrow(() -> CommonException.of(ErrorCode.BAD_REQUEST));

    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
      throw CommonException.of(ErrorCode.BAD_REQUEST);
    }

    return AuthDTO.SessionToken.builder()
        .accessToken(accessTokenProvider.create(user))
        .refreshToken(refreshTokenProvider.create(user))
        .build();
  }

  public void registerNewUser(AuthDTO.SignUpRequest dto) {
    User user = User.builder()
        .username(dto.getUsername())
        .password(passwordEncoder.encode(dto.getPassword()))
        .name(dto.getName())
        .build();

    userRepository.save(user);
  }
}
