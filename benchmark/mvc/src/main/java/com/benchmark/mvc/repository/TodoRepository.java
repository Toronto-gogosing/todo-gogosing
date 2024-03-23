package com.benchmark.mvc.repository;

import com.benchmark.mvc.dataobject.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
