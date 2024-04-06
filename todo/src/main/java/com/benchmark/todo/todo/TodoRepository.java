package com.benchmark.todo.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByUserId(long userId);

  @Query(value = "SELECT * FROM todo.todo WHERE user_id = :userId "
      + "AND YEAR(due_date) = :year AND MONTH(due_date) = :month AND DAY(due_date) = :day ORDER BY due_date", nativeQuery = true)
  List<Todo> findAllByDate(@Param("userId") long userId, @Param("year") int year, @Param("month") int month, @Param("day") int day);

  @Query(value = "SELECT DISTINCT DAY(due_date) FROM todo.todo WHERE user_id = :userId AND YEAR(due_date) = :year AND MONTH(due_date) = :month ORDER BY DAY(due_date)", nativeQuery = true)
  List<Integer> findDatesPresent(@Param("userId") long userId, @Param("year") int year, @Param("month") int month);
}
