package ru.digitalhabbits.spring.model;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
}
