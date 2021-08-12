package ru.digitalhabbits.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalhabbits.spring.user.domain.User;

public interface UserRepository
        extends JpaRepository<User, Integer> {}
