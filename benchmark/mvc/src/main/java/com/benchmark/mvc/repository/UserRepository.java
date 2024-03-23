package com.benchmark.mvc.repository;

import com.benchmark.mvc.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
