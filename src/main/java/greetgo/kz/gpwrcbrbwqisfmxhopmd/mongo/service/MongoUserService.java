package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model.MongoUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;

import java.util.List;

public interface MongoUserService {

    List<MongoUser> getFilteredUsers(Filter filter);

    MongoUser getUserById(String id);

    MongoUser getUserByPhoneNumber(String phoneNumber);

    MongoUser updateUserById(String id, MongoUser updatedUser);

    MongoUser updateUserByPhoneNumber(String phoneNumber, MongoUser updatedUser);

    void deleteUserById(String id);

    void deleteUserByPhoneNumber(String phoneNumber);
}
