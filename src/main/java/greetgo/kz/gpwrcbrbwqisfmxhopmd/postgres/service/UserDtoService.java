package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.UserDto;

import java.util.List;

public interface UserDtoService {

    List<UserDto> getFilteredUserDtos(Filter filter);

    UserDto getUserDtoById(Long id);

    UserDto getUserDtoByPhoneNumber(String phoneNumber);

    UserDto updateUserDtoById(Long id, UserDto updatedUser);

    UserDto updateUserDtoByPhoneNumber(String phoneNumber,  UserDto updatedUser);

    void deleteUserDtoById(Long id);

    void deleteUserDtoByPhoneNumber(String phoneNumber);
}
