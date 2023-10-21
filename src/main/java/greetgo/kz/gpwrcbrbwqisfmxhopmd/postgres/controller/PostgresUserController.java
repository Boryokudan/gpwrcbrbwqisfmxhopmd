package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.controller;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.service.UserService;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/postgres")
@RequiredArgsConstructor
public class PostgresUserController {

    private final UserService userService;

    @GetMapping("/filter")
    public List<UserDto> getUsers() {
        return null;
    }
}
