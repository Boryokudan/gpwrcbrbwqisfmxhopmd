package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.mapper;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model.MongoUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.MongoUserDto;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MongoUserMapper {

    MongoUserDto toDto(MongoUser mongoUser);
    MongoUser toEntity(MongoUserDto mongoUserDto);
    List<MongoUserDto> toDtoList(List<MongoUser> mongoUsers);
    List<MongoUser> toEntityList(List<MongoUserDto> mongoUserDtos);
}