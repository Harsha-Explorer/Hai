package com.app.hai.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "users_table")
@Data
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @NotNull(message = "Username cannot be null")
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull(message = "password cannot be null")
    private String password;
}
