package ru.digitalhabbits.spring.user.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.digitalhabbits.spring.user.model.CreateUserRequest;
import ru.digitalhabbits.spring.user.model.UserInfoResponse;

import java.util.List;

public interface UserService {
    @NotNull
    List<UserInfoResponse> findAll();

    @Nullable
    UserInfoResponse getById(@NotNull Integer id);

    int create(@NotNull CreateUserRequest request);

    @NotNull
    UserInfoResponse update(int id, @NotNull CreateUserRequest request);

    void delete(int id);
}
