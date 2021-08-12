package ru.digitalhabbits.spring.user.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoResponse {
    private Integer id;
    private String login;
    private String fullName;
    private Integer age;
}
