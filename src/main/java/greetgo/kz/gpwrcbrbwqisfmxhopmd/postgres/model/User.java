package greetgo.kz.gpwrcbrbwqisfmxhopmd.postgres.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private LocalDate registrationDate;

    private String primaryPhoneNumber;

    private String secondaryPhoneNumber;

    @PrePersist
    public void setRegistrationDate() {
        if (this.registrationDate == null) this.registrationDate = LocalDate.now();
    }
}