package com.example.sales.repo;

import com.example.sales.model.User;

public interface UserRepository {
    User save(User model);

    User findById(Long id);

    void delete(Long id);

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsById(Long id);
}
