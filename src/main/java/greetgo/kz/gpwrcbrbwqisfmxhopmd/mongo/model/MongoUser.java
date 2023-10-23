package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoUser {

    @Id
    private String id;

    @Field("full_name")
    private String fullName;

    @Field(value = "birthdate", targetType = FieldType.DATE_TIME)
    private LocalDate birthdate;

    @Field(value = "registration_date", targetType = FieldType.DATE_TIME)
    private LocalDate registrationDate;

    @Field("primary_phone_number")
    private String primaryPhoneNumber;

    @Field("secondary_phone_number")
    private String secondaryPhoneNumber;
}