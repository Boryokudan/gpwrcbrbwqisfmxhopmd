package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.repository.UserRepository;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.UserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getFilteredUsers(Filter filter) {
        Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit());
        Page<User> page = userRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
    }

    @Override
    public User updateUserById(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        user = updateCredentials(user, updatedUser);
        return user != null ? userRepository.save(user) : null;
    }

    @Override
    public User updateUserByPhoneNumber(String phoneNumber,  User updatedUser) {
        User user = userRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
        user = updateCredentials(user, updatedUser);
        return user != null ? userRepository.save(user) : null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserByPhoneNumber(String phoneNumber) {
        userRepository.deleteUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
    }

    private User updateCredentials(User existing, User updated) {
        if (existing != null) {
            if (updated.getFullName() != null) existing.setFullName(updated.getFullName());
            if (updated.getBirthDate() != null) existing.setBirthDate(updated.getBirthDate());
            if (updated.getPrimaryPhoneNumber() != null) existing.setPrimaryPhoneNumber(updated.getPrimaryPhoneNumber());
            if (updated.getSecondaryPhoneNumber() != null) existing.setSecondaryPhoneNumber(updated.getSecondaryPhoneNumber());
        }

        return existing;
    }
}
