package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.repository;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model.MongoUser;
import jakarta.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MongoUserRepository extends MongoRepository<MongoUser, String> {

    @Query("{$or:[ {'primaryPhoneNumber': ?0}, {'secondaryPhoneNumber': ?0} ]}")
    MongoUser findUserByPrimaryOrSecondaryPhoneNumber(String phoneNumber);

    @Query("{$or:[ {'primaryPhoneNumber': ?0}, {'secondaryPhoneNumber': ?0} ]}")
    void deleteUserByPrimaryOrSecondaryPhoneNumber(String phoneNumber);
}
