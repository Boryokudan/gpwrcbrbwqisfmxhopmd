package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.mapper.PostgresUserMapper;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.PostgresUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.PostgresUserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.PostgresUserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostgresUserDtoServiceImpl implements PostgresUserDtoService {

    private final PostgresUserService postgresUserService;

    private final PostgresUserMapper mapper;

    @Override
    public List<PostgresUserDto> getFilteredUserDtos(Filter filter) {
        return mapper.toDtoList(postgresUserService.getFilteredUsers(filter));
    }

    @Override
    public PostgresUserDto getUserDtoById(Long id) {
        return mapper.toDto(postgresUserService.getUserById(id));
    }

    @Override
    public PostgresUserDto getUserDtoByPhoneNumber(String phoneNumber) {
        return mapper.toDto(postgresUserService.getUserByPhoneNumber(phoneNumber));
    }

    @Override
    public PostgresUserDto updateUserDtoById(Long id, PostgresUserDto updatedUserDto) {
        PostgresUser updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(postgresUserService.updateUserById(id, updatedUser));
    }

    @Override
    public PostgresUserDto updateUserDtoByPhoneNumber(String phoneNumber, PostgresUserDto updatedUserDto) {
        PostgresUser updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(postgresUserService.updateUserByPhoneNumber(phoneNumber, updatedUser));
    }

    @Override
    public void deleteUserDtoById(Long id) {
        postgresUserService.deleteUserById(id);
    }

    @Override
    public void deleteUserDtoByPhoneNumber(String phoneNumber) {
        postgresUserService.deleteUserByPhoneNumber(phoneNumber);
    }
}
