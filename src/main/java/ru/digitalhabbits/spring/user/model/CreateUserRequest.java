package ru.digitalhabbits.spring.user.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {
    private String login;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
}
