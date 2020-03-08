package Validation;


import java.util.Scanner;

import InputCustomerException.*;

public class InputCustomerValidation {
    Scanner scanner;
    String regex;

    public InputCustomerValidation() {
        scanner = new Scanner(System.in);
    }

    public String getValidCustomerName() throws NameException {
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        System.out.print("Enter Name Customer (Format Abc Abc): ");
        String customerName = scanner.nextLine();
        if (customerName.matches(regex)) {
            return customerName;
        } else {
            throw new NameException("Customer's name is not valid.");
        }
    }

    public String getValidIdCard() throws IdCardException {
        regex = "^\\d{3}\\s\\d{3}\\s\\d{3}$";
        System.out.print("Enter Id Card (Format XXX XXX XXX): ");
        String idCard = scanner.nextLine();
        if (idCard.matches(regex)) {
            return idCard;
        } else {
            throw new IdCardException("Id card is not valid.");
        }
    }
    public String getValidEmail() throws EmailException {
        regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        System.out.print("Enter Email (Format abc@abc.abc): ");
        String email = scanner.nextLine();
        if (email.matches(regex)) {
            return email;
        } else {
            throw new EmailException("Email is not valid.");
        }
    }
    public String getValidGender() throws GenderException {
        regex="^male$|^female$";
        System.out.print("Enter Gender (male, female): ");
        String gender = scanner.nextLine();
        if (gender.matches(regex)) {
            return gender;
        } else {
            throw new GenderException("Gender is not valid.");
        }
    }
    public String getValidBirthDay() throws BirthdayException {
        regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        System.out.print("Enter Birthday Customer (Format dd/MM/yyyy): ");
        String birthDay = scanner.nextLine();
        if (birthDay.matches(regex)) {
            return birthDay;
        } else {
            throw new BirthdayException("BirthDay is not valid.");
        }
    }
}
