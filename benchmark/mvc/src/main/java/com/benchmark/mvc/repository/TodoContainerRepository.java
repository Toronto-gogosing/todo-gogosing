package com.benchmark.mvc.repository;

import com.benchmark.mvc.dataobject.TodoByDate;
import com.benchmark.mvc.dataobject.TodoContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoContainerRepository extends JpaRepository<TodoContainer, Integer> {
}
