package ru.digitalhabbits.spring.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
}
