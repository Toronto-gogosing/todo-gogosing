package com.benchmark.webflux.user;

import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.data.annotation.Id;


@Getter
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
