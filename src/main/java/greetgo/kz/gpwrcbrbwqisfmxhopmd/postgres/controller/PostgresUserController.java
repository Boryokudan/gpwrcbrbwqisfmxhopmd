package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.controller;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.UserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/postgres")
@RequiredArgsConstructor
public class PostgresUserController {

    private final UserDtoService userDtoService;

    @PostMapping("/filter")
    public ResponseEntity<List<UserDto>> getUsers(@RequestBody Filter filter) {
        List<UserDto> filteredUsers = userDtoService.getFilteredUserDtos(filter);
        if (!filteredUsers.isEmpty()) return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        UserDto userDto = userDtoService.getUserDtoById(id);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable(name = "id") Long id, @RequestBody UserDto updatedUserDto) {
        UserDto userDto = userDtoService.updateUserDtoById(id, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber) {
        UserDto userDto = userDtoService.getUserDtoByPhoneNumber(phoneNumber);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/phone/{phoneNumber}")
    public ResponseEntity<UserDto> updateUserByPhoneNumber(
            @PathVariable(name = "phoneNumber") String phoneNumber,
            @RequestBody UserDto updatedUserDto) {
        UserDto userDto = userDtoService.updateUserDtoByPhoneNumber(phoneNumber, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
