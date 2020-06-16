package com.codegym.finalexam.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.codegym.finalexam.validation.AgeRange;
import com.codegym.finalexam.validation.IdentityCard;
import com.codegym.finalexam.validation.PhoneNumber;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_code")
    @NotBlank(message = "Employee code is required")
    private String employeeCode;
    @Column(name = "full_name")
    @NotBlank(message = "FullName is required")
    private String fullName;
    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @AgeRange(min = 18, max = 80)
    private Date dateOfBirth;
    @Column(name = "phone_number")
    @PhoneNumber(message = "Phone number is invalid")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @Column(name = "id_card_number")
    @NotBlank(message = "Id card number is required")
    @IdentityCard(message = "Id card number is invalid")
    private String idCardNumber;
    @Column(name = "email")
    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
    @Column(name = "address")
    @NotBlank(message = "Address is required")
    private String address;
    @ManyToOne(targetEntity = EmployeeGroup.class)
    @JoinColumn(name = "group_id")
    private EmployeeGroup employeeGroup;

    public Employee() {
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}