package com.benchmark.todo.user.service;

import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo.user.dto.UserDTO;
import com.benchmark.todo.user.entity.User;
import com.benchmark.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserDTO.Slim fetchUser(Long id) {
    User user = userRepository.findById(id).orElseThrow(() ->
        CommonException.of(ErrorCode.NOT_FOUND)
    );

    return UserDTO.Slim.of(user);
  }
}
