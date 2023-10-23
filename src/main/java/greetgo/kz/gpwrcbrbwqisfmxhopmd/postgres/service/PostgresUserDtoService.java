package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;

import java.util.List;

public interface PostgresUserDtoService {

    List<PostgresUserDto> getFilteredUserDtos(Filter filter);

    PostgresUserDto getUserDtoById(Long id);

    PostgresUserDto getUserDtoByPhoneNumber(String phoneNumber);

    PostgresUserDto updateUserDtoById(Long id, PostgresUserDto updatedUser);

    PostgresUserDto updateUserDtoByPhoneNumber(String phoneNumber, PostgresUserDto updatedUser);

    void deleteUserDtoById(Long id);

    void deleteUserDtoByPhoneNumber(String phoneNumber);
}
