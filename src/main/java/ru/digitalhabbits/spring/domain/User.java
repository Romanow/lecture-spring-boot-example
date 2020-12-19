package ru.digitalhabbits.spring.domain;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("login", login)
                .add("firstName", firstName)
                .add("middleName", middleName)
                .add("lastName", lastName)
                .add("age", age)
                .toString();
    }
}
