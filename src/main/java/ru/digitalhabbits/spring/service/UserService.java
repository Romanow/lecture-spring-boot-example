package ru.digitalhabbits.spring.service;

import ru.digitalhabbits.spring.model.CreateUserRequest;
import ru.digitalhabbits.spring.model.UserInfoResponse;

import javax.annotation.Nonnull;
import java.util.List;

public interface UserService {
    List<UserInfoResponse> getAllUsers();

    UserInfoResponse getUserById(@Nonnull Integer id);

    UserInfoResponse createUser(@Nonnull CreateUserRequest request);

    UserInfoResponse editUser(@Nonnull Integer id, @Nonnull CreateUserRequest request);

    void deleteUser(@Nonnull Integer id);
}
