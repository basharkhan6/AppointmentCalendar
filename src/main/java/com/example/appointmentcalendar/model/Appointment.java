package com.example.appointmentcalendar.model;

import com.example.appointmentcalendar.model.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    @NotBlank(message = "First Name should be present")
    private String firstName;

    @Size(max = 40)
    @NotBlank(message = "Last Name should be present")
    private String lastName;

    @Email(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Valid email address should be present")
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    @NotNull(message = "Date should be present")
    private LocalDate date;

    @NotNull(message = "Time should be present")
    private LocalTime time;

}
