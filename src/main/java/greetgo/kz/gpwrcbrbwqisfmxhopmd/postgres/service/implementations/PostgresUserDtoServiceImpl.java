package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.mapper.UserMapper;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model.User;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.UserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.UserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDtoServiceImpl implements UserDtoService {

    private final UserService userService;

    private final UserMapper mapper;

    @Override
    public List<UserDto> getFilteredUserDtos(Filter filter) {
        return mapper.toDtoList(userService.getFilteredUsers(filter));
    }

    @Override
    public UserDto getUserDtoById(Long id) {
        return mapper.toDto(userService.getUserById(id));
    }

    @Override
    public UserDto getUserDtoByPhoneNumber(String phoneNumber) {
        return mapper.toDto(userService.getUserByPhoneNumber(phoneNumber));
    }

    @Override
    public UserDto updateUserDtoById(Long id, UserDto updatedUserDto) {
        User updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(userService.updateUserById(id, updatedUser));
    }

    @Override
    public UserDto updateUserDtoByPhoneNumber(String phoneNumber, UserDto updatedUserDto) {
        User updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(userService.updateUserByPhoneNumber(phoneNumber, updatedUser));
    }

    @Override
    public void deleteUserDtoById(Long id) {
        userService.deleteUserById(id);
    }

    @Override
    public void deleteUserDtoByPhoneNumber(String phoneNumber) {
        userService.deleteUserByPhoneNumber(phoneNumber);
    }
}
