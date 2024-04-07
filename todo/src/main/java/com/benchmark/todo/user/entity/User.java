package com.benchmark.todo.user.entity;

import com.benchmark.todo.todo.Todo;
import jakarta.persistence.*;
import java.util.ArrayList;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id = null;

  @Column(name = "username", unique = true)
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  // TODO: How do we load this when needed?
  // TODO: How does this get updated when new Todo is created?

  // One to many joincolumn -> left join when queried
  // This might not be necessary to have for User. We could query this directly from database through repository.
  @OneToMany
  @JoinColumn(name="user_id")
  private final List<Todo> todoList = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
