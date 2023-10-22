package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String fullName;

    private LocalDate birthdate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}
