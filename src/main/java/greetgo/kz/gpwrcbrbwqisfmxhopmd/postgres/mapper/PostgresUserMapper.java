package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.mapper;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostgresUserMapper {

    PostgresUserDto toDto(PostgresUser postgresUser);
    PostgresUser toEntity(PostgresUserDto postgresUserDto);
    List<PostgresUserDto> toDtoList(List<PostgresUser> postgresUsers);
    List<PostgresUser> toEntityList(List<PostgresUserDto> postgresUserDtos);
}