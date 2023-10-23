package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.implementations;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.mapper.MongoUserMapper;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model.MongoUser;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.MongoUserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.MongoUserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.MongoUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserDtoServiceImpl implements MongoUserDtoService {

    private final MongoUserService mongoUserService;

    private final MongoUserMapper mapper;

    @Override
    public List<MongoUserDto> getFilteredUserDtos(Filter filter) {
        return mapper.toDtoList(mongoUserService.getFilteredUsers(filter));
    }

    @Override
    public MongoUserDto getUserDtoById(String id) {
        return mapper.toDto(mongoUserService.getUserById(id));
    }

    @Override
    public MongoUserDto getUserDtoByPhoneNumber(String phoneNumber) {
        return mapper.toDto(mongoUserService.getUserByPhoneNumber(phoneNumber));
    }

    @Override
    public MongoUserDto updateUserDtoById(String id, MongoUserDto updatedUserDto) {
        MongoUser updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(mongoUserService.updateUserById(id, updatedUser));
    }

    @Override
    public MongoUserDto updateUserDtoByPhoneNumber(String phoneNumber, MongoUserDto updatedUserDto) {
        MongoUser updatedUser = mapper.toEntity(updatedUserDto);
        return mapper.toDto(mongoUserService.updateUserByPhoneNumber(phoneNumber, updatedUser));
    }

    @Override
    public void deleteUserDtoById(String id) {
        mongoUserService.deleteUserById(id);
    }

    @Override
    public void deleteUserDtoByPhoneNumber(String phoneNumber) {
        mongoUserService.deleteUserByPhoneNumber(phoneNumber);
    }
}
