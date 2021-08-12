package ru.digitalhabbits.spring.user.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalhabbits.spring.user.model.CreateUserRequest;
import ru.digitalhabbits.spring.user.model.UserInfoResponse;
import ru.digitalhabbits.spring.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Find all users")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserInfoResponse> users() {
        return userService.findAll();
    }

    @Operation(summary = "Get user by ID")
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserInfoResponse getUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody CreateUserRequest request) {
        int userId = userService.create(request);
        return ResponseEntity.created(
                fromCurrentRequest()
                        .path("/{userId}")
                        .buildAndExpand(userId)
                        .toUri()
        ).build();
    }

    @PatchMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserInfoResponse update(@PathVariable Integer id, @RequestBody CreateUserRequest request) {
        return userService.update(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
