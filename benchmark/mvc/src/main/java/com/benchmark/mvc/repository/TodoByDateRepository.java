package com.benchmark.mvc.repository;

import com.benchmark.mvc.dataobject.Todo;
import com.benchmark.mvc.dataobject.TodoByDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoByDateRepository extends JpaRepository<TodoByDate, Integer> {
}
