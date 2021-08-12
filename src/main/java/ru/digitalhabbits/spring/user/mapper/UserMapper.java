package ru.digitalhabbits.spring.user.mapper;

import com.google.common.base.Joiner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.digitalhabbits.spring.user.domain.User;
import ru.digitalhabbits.spring.user.model.CreateUserRequest;
import ru.digitalhabbits.spring.user.model.UserInfoResponse;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        imports = { Joiner.class })
public interface UserMapper {

    @Mapping(target = "fullName", expression = "java(Joiner.on(\" \").skipNulls().join(user.getLastName(), user.getFirstName(), user.getMiddleName()))")
    UserInfoResponse toModel(User user);

    @Mapping(target = "id", ignore = true)
    User toDomain(CreateUserRequest request);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget User user, CreateUserRequest request);
}
