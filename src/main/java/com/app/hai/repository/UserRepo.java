package com.app.hai.repository;

import com.app.hai.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UsersModel,Long> {
    UsersModel findByUsername(String username);
}
