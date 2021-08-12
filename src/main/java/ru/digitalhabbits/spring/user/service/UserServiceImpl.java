package ru.digitalhabbits.spring.user.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import ru.digitalhabbits.spring.user.domain.User;
import ru.digitalhabbits.spring.user.exceptions.EntityNotFoundException;
import ru.digitalhabbits.spring.user.mapper.UserMapper;
import ru.digitalhabbits.spring.user.model.CreateUserRequest;
import ru.digitalhabbits.spring.user.model.UserInfoResponse;
import ru.digitalhabbits.spring.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public @NotNull List<UserInfoResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public @Nullable UserInfoResponse getById(@NotNull Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toModel)
                .orElseThrow(() -> new EntityNotFoundException("User '" + id + "' not found"));
    }

    @Override
    public int create(@NotNull CreateUserRequest request) {
        final User user = userRepository.save(userMapper.toDomain(request));
        return user.getId();
    }

    @Override
    public @NotNull UserInfoResponse update(int id, @NotNull CreateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User '" + id + "' not found"));
        userMapper.update(user, request);
        return userMapper.toModel(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
