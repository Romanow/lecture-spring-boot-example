package ru.digitalhabbits.spring.repository;

import ru.digitalhabbits.spring.domain.User;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public interface UserStorage {
    @Nonnull
    List<User> getAllUsers();

    @Nonnull
    Optional<User> getUserById(@Nonnull Integer id);

    @Nonnull
    User createUser(@Nonnull User user);

    void delete(@Nonnull Integer id);

    void update(@Nonnull User user);
}
