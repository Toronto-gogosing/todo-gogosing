package com.benchmark.todo.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByUserId(long userId);

  // TODO: look up date format for query
  // LocalDateTime due_date -> 2025-01
//  @Query("SELECT DISTINCT DAY(due_date) FROM todo WHERE due_date LIKE 'month%' ORDER BY DAY(due_date)")
//  List<Integer> findDatesPresent(@Param("month") String month);
}
