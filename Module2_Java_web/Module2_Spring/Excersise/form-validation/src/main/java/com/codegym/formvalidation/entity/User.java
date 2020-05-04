package com.codegym.formvalidation.entity;

import com.codegym.formvalidation.validation.AgeRange;
import com.codegym.formvalidation.validation.ValidName;
import com.codegym.formvalidation.validation.ValidPhoneNumber;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class User {
    @ValidName
    private String firstName;
    @ValidName
    private String lastName;
    @AgeRange(min = 18, max = 50)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDay;
    @ValidPhoneNumber
    @NotBlank(message = "Phone number is required.")
    private String phoneNumber;
    @Email
    @NotBlank(message = "Email is required.")
    private String email;

    =

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
