package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.repository.PostgresUserRepository;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.PostgresUserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.FilteredPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostgresUserServiceImpl implements PostgresUserService {

    private final Sort DEFAULT_SORT = Sort.by(Sort.Direction.ASC, "id");

    private final PostgresUserRepository postgresUserRepository;

    @Override
    public List<PostgresUser> getFilteredUsers(Filter filter) {
        Pageable pageable = new FilteredPage(filter, DEFAULT_SORT);
        return postgresUserRepository.findAll(pageable).getContent();
    }

    @Override
    public PostgresUser getUserById(Long id) {
        return postgresUserRepository.findById(id).orElse(null);
    }

    @Override
    public PostgresUser getUserByPhoneNumber(String phoneNumber) {
        return postgresUserRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
    }

    @Override
    public PostgresUser updateUserById(Long id, PostgresUser updatedUser) {
        PostgresUser existingUser = postgresUserRepository.findById(id).orElse(null);
        existingUser = updateCredentials(existingUser, updatedUser);
        return existingUser != null ? postgresUserRepository.save(existingUser) : null;
    }

    @Override
    public PostgresUser updateUserByPhoneNumber(String phoneNumber, PostgresUser updatedUser) {
        PostgresUser existingUser = postgresUserRepository.findUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
        existingUser = updateCredentials(existingUser, updatedUser);
        return existingUser != null ? postgresUserRepository.save(existingUser) : null;
    }

    @Override
    public void deleteUserById(Long id) {
        postgresUserRepository.deleteById(id);
    }

    @Override
    public void deleteUserByPhoneNumber(String phoneNumber) {
        postgresUserRepository.deleteUserByPrimaryOrSecondaryPhoneNumber(phoneNumber);
    }

    private PostgresUser updateCredentials(PostgresUser existing, PostgresUser updated) {
        if (existing != null) {
            existing.setFullName(updated.getFullName());
            existing.setBirthdate(updated.getBirthdate());
            existing.setPrimaryPhoneNumber(updated.getPrimaryPhoneNumber());
            existing.setSecondaryPhoneNumber(updated.getSecondaryPhoneNumber());
        }
        return existing;
    }
}
