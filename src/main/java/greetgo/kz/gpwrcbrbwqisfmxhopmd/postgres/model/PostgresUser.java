package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private LocalDate birthdate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;
}