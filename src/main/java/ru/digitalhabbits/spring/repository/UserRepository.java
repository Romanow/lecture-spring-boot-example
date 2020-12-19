package ru.digitalhabbits.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalhabbits.spring.domain.User;

public interface UserRepository
        extends JpaRepository<User, Integer> {
}
