package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.controller;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.PostgresUserDtoService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.common.Filter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.PostgresUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/postgres")
@RequiredArgsConstructor
public class PostgresUserController {

    private final PostgresUserDtoService postgresUserDtoService;

    @PostMapping("/filter")
    public ResponseEntity<List<PostgresUserDto>> getFilteredUsers(@RequestBody Filter filter) {
        List<PostgresUserDto> filteredUsers;
        try {
            filteredUsers = postgresUserDtoService.getFilteredUserDtos(filter);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (filteredUsers != null && !filteredUsers.isEmpty()) return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostgresUserDto> getUserById(@PathVariable(name = "id") Long id) {
        PostgresUserDto postgresUserDto = postgresUserDtoService.getUserDtoById(id);
        if (postgresUserDto != null) return new ResponseEntity<>(postgresUserDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostgresUserDto> updateUserById(@PathVariable(name = "id") Long id, @RequestBody PostgresUserDto updatedUserDto) {
        PostgresUserDto userDto = postgresUserDtoService.updateUserDtoById(id, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id) {
        postgresUserDtoService.deleteUserDtoById(id);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<PostgresUserDto> getUserByPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber) {
        PostgresUserDto userDto = postgresUserDtoService.getUserDtoByPhoneNumber(phoneNumber);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/phone/{phoneNumber}")
    public ResponseEntity<PostgresUserDto> updateUserByPhoneNumber(
            @PathVariable(name = "phoneNumber") String phoneNumber,
            @RequestBody PostgresUserDto updatedUserDto) {
        PostgresUserDto userDto = postgresUserDtoService.updateUserDtoByPhoneNumber(phoneNumber, updatedUserDto);
        if (userDto != null) return new ResponseEntity<>(userDto, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/phone/{phoneNumber}")
    public void deleteUserBPhoneNumber(@PathVariable(name = "phoneNumber") String phoneNumber) {
        postgresUserDtoService.deleteUserDtoByPhoneNumber(phoneNumber);
    }
}
