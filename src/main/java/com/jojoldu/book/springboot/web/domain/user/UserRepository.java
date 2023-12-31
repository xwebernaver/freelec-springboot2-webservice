package com.jojoldu.book.springboot.web.domain.user;

import com.jojoldu.book.springboot.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
