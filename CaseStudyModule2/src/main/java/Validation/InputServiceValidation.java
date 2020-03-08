package Validation;

import java.time.LocalDate;
import java.util.Scanner;

public class InputServiceValidation {
    private String regex = "";
    private Scanner scanner;
    public String getValidNameService() {
        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter service name (Format: Abc Abc): ");
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Service name is not valid.");
            }
        }
    }
    public String getValidTypeOfRent() {

        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Enter type rent (Format: Abc Abc): ");
            String typeOfRent = scanner.nextLine();
            if (typeOfRent.matches(regex)) {
                return typeOfRent;
            } else {
                System.out.println("Type of rent is not valid.");
            }
        }
    }
    public String getValidRoomStandard() {

        regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Enter room standard (Format: Abc Abc): ");
            String typeOfRent = scanner.nextLine();
            if (typeOfRent.matches(regex)) {
                return typeOfRent;
            } else {
                System.out.println("Room standard is not valid.");
            }
        }
    }
    public double getValidUsableArea() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Enter usable area: ");
                double area = scanner.nextDouble();
                if (area > 30) {
                    return area;
                } else {
                    System.out.println("Usable area must be greater 30. ");
                }
            } catch (Exception e) {
                System.out.println("The type of value is wrong.");
            }
        }
    }
    public double getValidPoolArea() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Enter pool area: ");
                double area = scanner.nextDouble();
                if (area > 30) {
                    return area;
                } else {
                    System.out.println("Pool area must be greater than 30. ");
                }
            } catch (Exception e) {
                System.out.println("The type of value is wrong.");
            }
        }
    }
    public double getValidRentalCosts() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.print("Enter Rental Costs: ");
                double rentalCosts = scanner.nextDouble();
                if (rentalCosts > 0) {
                    return rentalCosts;
                } else {
                    System.out.println("Rental Costs must be positive.");
                }
            } catch (Exception e) {
                System.out.println("The type of value is wrong.");
            }
        }
    }
    public int getValidNumberOfPeople() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.print("Enter Max Number Of People: ");
                int maxNumberOfPeople = scanner.nextInt();
                if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                    return maxNumberOfPeople;
                } else {
                    System.out.println("Max Number Of People must be greater than 0 and less than 20!");
                }
            } catch (Exception e) {
                System.out.println("The type of value is wrong.");
            }
        }
    }
    public int getNumberOfFloors() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.print("Enter Number Of Floors: ");
                int numberOfFloors = scanner.nextInt();
                if (numberOfFloors > 0) {
                    return numberOfFloors;
                } else {
                    System.out.println("Number Of Floors must be positive");
                }
            } catch (Exception e) {
                System.out.println("The type of value is wrong.");
            }
        }
    }
    public String getValidBirthday() {
        regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter birthday (format dd/MM/yyyy): ");
            String birthday = scanner.nextLine();
            LocalDate date = LocalDate.now();

            if (birthday.matches(regex)) {
                StringBuilder temp = new StringBuilder();
                for (int i = birthday.length() - 4; i < birthday.length(); i++) {
                    temp.append(birthday.charAt(i));
                }
                if (date.getYear() - new Integer(temp.toString()) >= 18) {
                    return birthday;
                } else {
                    System.out.println("Your age must be greater then 18: ");
                }

            } else {
                System.out.println("The type of value is wrong.");
            }
        }
    }
}
