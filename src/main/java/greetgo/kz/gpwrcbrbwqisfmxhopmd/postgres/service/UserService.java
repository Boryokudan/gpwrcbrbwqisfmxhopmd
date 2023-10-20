package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.Filter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getFilteredUsers(Filter filter);
    User getUserById(Long id);
    User getUserByPhoneNumber(String phoneNumber);
    User updateUserById(Long id);
    User updateUserByPhoneNumber(String phoneNumber);
    void deleteUserById(Long id);
    void deleteUserByPhoneNumber(String phoneNumber);
}
