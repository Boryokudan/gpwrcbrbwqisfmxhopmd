package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.mapper;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> userDtos);
}