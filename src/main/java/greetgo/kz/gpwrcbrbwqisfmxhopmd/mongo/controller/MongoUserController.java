package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.controller;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.service.MongoUserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.MongoUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo")
@RequiredArgsConstructor
public class MongoUserController {

    private final MongoUserDtoService mongoUserDtoService;

    @PostMapping("/filter")
    public ResponseEntity<List<MongoUserDto>> getFilteredUsers(@RequestBody Filter filter) {
        List<MongoUserDto> filteredUsers;
        try {
            filteredUsers = mongoUserDtoService.getFilteredUserDtos(filter);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (filteredUsers != null && !filteredUsers.isEmpty()) return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<MongoUserDto> getUserById(@PathVariable(name = "id") String id) {
        MongoUserDto mongoUserDto = mongoUserDtoService.getUserDtoById(id);
        if (mongoUserDto != null) return new ResponseEntity<>(mongoUserDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<MongoUserDto> updateUserById(@PathVariable(name = "id") String id,
                                                       @RequestBody MongoUserDto updatedUserDto) {
        MongoUserDto userDto = mongoUserDtoService.updateUserDtoById(id, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable(name = "id") String id) {
        mongoUserDtoService.deleteUserDtoById(id);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<MongoUserDto> getUserByPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber) {
        MongoUserDto userDto = mongoUserDtoService.getUserDtoByPhoneNumber(phoneNumber);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/phone/{phoneNumber}")
    public ResponseEntity<MongoUserDto> updateUserByPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber,
                                                                   @RequestBody MongoUserDto updatedUserDto) {
        MongoUserDto userDto = mongoUserDtoService.updateUserDtoByPhoneNumber(phoneNumber, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/phone/{phoneNumber}")
    public void deleteUserBPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber) {
        mongoUserDtoService.deleteUserDtoByPhoneNumber(phoneNumber);
    }
}
