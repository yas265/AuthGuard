package com.authGuard.AuthGuard.repository;

import com.authGuard.AuthGuard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUserName(String username);
}
