package com.benchmark.todo.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByUserId(long userId);

  @Query(value = "SELECT * FROM todo.todo WHERE user_id = :userId "
      + "AND DATE(due_date) = :date ORDER BY due_date", nativeQuery = true)
  List<Todo> findAllByDate(@Param("userId") long userId, @Param("date") String date);

  // GROUP BY is faster than DISTINCT as it doesn't require ordering in the process
  @Query(value = "SELECT DISTINCT DAY(due_date) FROM todo.todo WHERE user_id = :userId AND DATE_FORMAT(due_date, '%Y-%m') = :date "
      + "ORDER BY due_date"
      , nativeQuery = true)
  List<Integer> findDatesPresent(@Param("userId") long userId, @Param("date") String date);
}
