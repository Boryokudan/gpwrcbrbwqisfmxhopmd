package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostgresUserDto {

    private Long id;

    private String fullName;

    private LocalDate birthdate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}
