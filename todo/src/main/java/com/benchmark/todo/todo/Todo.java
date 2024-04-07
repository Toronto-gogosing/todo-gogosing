package com.benchmark.todo.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id = null;
  private LocalDateTime dueDate;
  private String description;
  @Column(name = "user_id")
  private Long userId;

  // TODO: consider adding "owned-by method" to verify ownership.
  // Take User user instead, and check inside.
  public boolean isOwnedBy(long id) {
    return this.userId == id;
  }
}
