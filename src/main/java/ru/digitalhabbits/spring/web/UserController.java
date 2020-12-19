package ru.digitalhabbits.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.digitalhabbits.spring.model.CreateUserRequest;
import ru.digitalhabbits.spring.model.UserInfoResponse;
import ru.digitalhabbits.spring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserInfoResponse> users() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserInfoResponse getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserInfoResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping("/{id}")
    public UserInfoResponse editUser(@PathVariable Integer id, @RequestBody CreateUserRequest request) {
        return userService.editUser(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
