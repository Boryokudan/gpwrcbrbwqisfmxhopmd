package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.MongoUserDto;

import java.util.List;

public interface MongoUserDtoService {

    List<MongoUserDto> getFilteredUserDtos(Filter filter);

    MongoUserDto getUserDtoById(String id);

    MongoUserDto getUserDtoByPhoneNumber(String phoneNumber);

    MongoUserDto updateUserDtoById(String id, MongoUserDto updatedUser);

    MongoUserDto updateUserDtoByPhoneNumber(String phoneNumber, MongoUserDto updatedUser);

    void deleteUserDtoById(String id);

    void deleteUserDtoByPhoneNumber(String phoneNumber);
}
