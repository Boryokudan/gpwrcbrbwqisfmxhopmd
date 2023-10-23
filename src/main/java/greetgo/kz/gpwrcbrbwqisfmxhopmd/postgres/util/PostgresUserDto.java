package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;

    private String fullName;

    private LocalDate birthdate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}
