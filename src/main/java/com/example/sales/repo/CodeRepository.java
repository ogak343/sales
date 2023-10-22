package com.example.sales.repo;

import com.example.sales.entity.ConfirmationCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<ConfirmationCodeEntity, Long> {
    @Query(value = "select cc from confirmation_code cc join users u on u.id = cc.user_id where u.username =:username",
            nativeQuery = true)
    Optional<ConfirmationCodeEntity> findByUsername(String username);
}
