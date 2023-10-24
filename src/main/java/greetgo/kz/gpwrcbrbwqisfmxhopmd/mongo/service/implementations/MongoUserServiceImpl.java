package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.FilteredPage;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model.MongoUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.repository.MongoUserRepository;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.MongoUserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserServiceImpl implements MongoUserService {

    private final Sort DEFAULT_SORT = Sort.by(Sort.Direction.ASC, "id");

    private final MongoUserRepository mongoUserRepository;

    @Override
    public List<MongoUser> getFilteredUsers(Filter filter) {
        Pageable pageable = new FilteredPage(filter, DEFAULT_SORT);
        return mongoUserRepository.findAll(pageable).getContent();
    }

    @Override
    public MongoUser getUserById(String id) {
        return mongoUserRepository.findById(id).orElse(null);
    }

    @Override
    public MongoUser getUserByPhoneNumber(String phoneNumber) {
        return mongoUserRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
    }

    @Override
    public MongoUser updateUserById(String id, MongoUser updatedUser) {
        MongoUser existingUser = mongoUserRepository.findById(id).orElse(null);
        existingUser = updateCredentials(existingUser, updatedUser);
        return existingUser != null ? mongoUserRepository.save(existingUser) : null;
    }

    @Override
    public MongoUser updateUserByPhoneNumber(String phoneNumber, MongoUser updatedUser) {
        MongoUser existingUser = mongoUserRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
        existingUser = updateCredentials(existingUser, updatedUser);
        return existingUser != null ? mongoUserRepository.save(existingUser) : null;
    }

    @Override
    public void deleteUserById(String id) {
        mongoUserRepository.deleteById(id);
    }

    @Override
    public void deleteUserByPhoneNumber(String phoneNumber) {
        MongoUser existingUser = mongoUserRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
        if (existingUser != null) mongoUserRepository.delete(existingUser);
    }

    private MongoUser updateCredentials(MongoUser existing, MongoUser updated) {
        if (existing != null) {
            existing.setFullName(updated.getFullName());
            existing.setBirthdate(updated.getBirthdate());
            existing.setPrimaryPhoneNumber(updated.getPrimaryPhoneNumber());
            existing.setSecondaryPhoneNumber(updated.getSecondaryPhoneNumber());
        }
        return existing;
    }
}
