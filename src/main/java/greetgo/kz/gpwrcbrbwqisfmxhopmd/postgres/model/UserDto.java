package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private LocalDate birthDate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}
