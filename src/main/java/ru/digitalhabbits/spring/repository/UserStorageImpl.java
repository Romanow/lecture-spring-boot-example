package ru.digitalhabbits.spring.repository;

import org.springframework.stereotype.Repository;
import ru.digitalhabbits.spring.domain.User;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserStorageImpl
        implements UserStorage {
    private final AtomicInteger counter = new AtomicInteger();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    @Override
    @Nonnull
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Nonnull
    @Override
    public Optional<User> getUserById(@Nonnull Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    @Nonnull
    @Override
    public User createUser(@Nonnull User user) {
        final int id = counter.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public void delete(@Nonnull Integer id) {
        users.remove(id);
    }

    @Override
    public void update(@Nonnull User user) {
        final Integer id = user.getId();
        users.put(id, user);
    }
}
