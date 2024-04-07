package com.benchmark.todo.user.service;

import com.benchmark.todo._core.error.CommonException;
import com.benchmark.todo._core.error.ErrorCode;
import com.benchmark.todo.user.dto.UserDTO;
import com.benchmark.todo.user.entity.User;
import com.benchmark.todo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public UserDTO.Slim fetchUserByUsername(Long id) {
    User user = userRepository.findById(id).orElseThrow(() ->
        CommonException.of(ErrorCode.NOT_FOUND)
    );

    System.out.println(user.getTodoList());
    return UserDTO.Slim.of(user);
  }
}
