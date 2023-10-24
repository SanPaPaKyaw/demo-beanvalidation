package com.example.demobeanvalidation.ds;

import com.example.demobeanvalidation.validation.NameNotAdmin;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NameNotAdmin(message = "First name cannot be admin!")
    @NotEmpty(message = "{myapp.validation.msg.firstname}")
    private String firstName;
    @NotEmpty(message = "Lastname cannot be empty!")
    private String lastName;
    @Min(value = 18,message = "You are too young!")
    @Max(value = 60,message = "You are too old!")
    private int age;
    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Invalid Email format!")
    private String email;


}
