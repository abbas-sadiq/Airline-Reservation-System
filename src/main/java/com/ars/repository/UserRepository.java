package com.ars.repository;

import com.ars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


}
