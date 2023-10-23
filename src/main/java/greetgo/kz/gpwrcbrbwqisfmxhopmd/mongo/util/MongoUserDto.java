package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MongoUserDto {

    private String id;

    private String fullName;

    private LocalDate birthdate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}
