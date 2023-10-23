package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;

import java.util.List;

public interface PostgresUserService {

    List<PostgresUser> getFilteredUsers(Filter filter);

    PostgresUser getUserById(Long id);

    PostgresUser getUserByPhoneNumber(String phoneNumber);

    PostgresUser updateUserById(Long id, PostgresUser updatedUser);

    PostgresUser updateUserByPhoneNumber(String phoneNumber, PostgresUser updatedUser);

    void deleteUserById(Long id);

    void deleteUserByPhoneNumber(String phoneNumber);
}
