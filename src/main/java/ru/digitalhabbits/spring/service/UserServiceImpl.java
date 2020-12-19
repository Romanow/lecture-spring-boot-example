package ru.digitalhabbits.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digitalhabbits.spring.domain.User;
import ru.digitalhabbits.spring.exceptions.UserNotFoundException;
import ru.digitalhabbits.spring.model.CreateUserRequest;
import ru.digitalhabbits.spring.model.UserInfoResponse;
import ru.digitalhabbits.spring.repository.UserStorage;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        implements UserService {
    private final UserStorage userStorage;

    @Override
    public List<UserInfoResponse> getAllUsers() {
        return userStorage.getAllUsers()
                .stream()
                .map(this::buildUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoResponse getUserById(@Nonnull Integer id) {
        final User user = userStorage.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User '" + id + "' not found"));
        return buildUserResponse(user);
    }

    @Override
    public UserInfoResponse createUser(@Nonnull CreateUserRequest request) {
        User user = new User()
                .setAge(request.getAge())
                .setFirstName(request.getFirstName())
                .setMiddleName(request.getMiddleName())
                .setLastName(request.getLastName())
                .setLogin(request.getLogin());
        user = userStorage.createUser(user);

        return buildUserResponse(user);
    }

    @Override
    public UserInfoResponse editUser(@Nonnull Integer id, @Nonnull CreateUserRequest request) {
        final User user = userStorage.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User '" + id + "' not found"));
        ofNullable(request.getAge()).map(user::setAge);
        ofNullable(request.getFirstName()).map(user::setFirstName);
        ofNullable(request.getMiddleName()).map(user::setMiddleName);
        ofNullable(request.getLastName()).map(user::setLastName);
        ofNullable(request.getLogin()).map(user::setLogin);

        userStorage.update(user);

        return buildUserResponse(user);
    }

    @Override
    public void deleteUser(@Nonnull Integer id) {
        userStorage.delete(id);
    }

    @Nonnull
    private UserInfoResponse buildUserResponse(@Nonnull User user) {
        return new UserInfoResponse()
                .setId(user.getId())
                .setAge(user.getAge())
                .setFullName(String.format("%s %s %s", user.getLastName(), user.getFirstName(), user.getMiddleName()))
                .setLogin(user.getLogin());
    }
}
