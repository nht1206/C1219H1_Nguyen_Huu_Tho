package Services;

import Commons.ReadWriteCSV;
import InputCustomerException.*;
import Models.Customer;
import Validation.InputCustomerValidation;


import java.util.*;

public class CustomerServices {
    private ReadWriteCSV readWriteCSV;
    List<Models.Customer> customers;
    private InputCustomerValidation inputCustomerValidation;


    public CustomerServices() {
        readWriteCSV = new ReadWriteCSV();
        inputCustomerValidation = new InputCustomerValidation();
        customers = readWriteCSV.readFileCustomerCSV();
    }

    public void addNewCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number list customer you want: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            Models.Customer customer = new Models.Customer();
            customer.setId(UUID.randomUUID().toString().replace("-", ""));
            while (true) {
                try {
                    customer.setNameCustomer(inputCustomerValidation.getValidCustomerName());
                    break;
                } catch (NameException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    customer.setIdCard(inputCustomerValidation.getValidIdCard());
                    break;
                } catch (IdCardException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    customer.setEmail(inputCustomerValidation.getValidEmail());
                    break;
                } catch (EmailException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Enter phone number: ");
            customer.setPhoneNumber(scanner.nextLine());
            while (true) {
                try {
                    customer.setGender(inputCustomerValidation.getValidGender());
                    break;
                } catch (GenderException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    customer.setBirthday(inputCustomerValidation.getValidBirthDay());
                    break;
                } catch (BirthdayException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Enter type of customer: ");
            customer.setTypeCustomer(scanner.nextLine());
            System.out.println("Enter the address: ");
            customer.setAddress(scanner.nextLine());
            customers.add(customer);
        }
        readWriteCSV.writeCustomerToCSVFile(customers);
    }

    public void showInfoCustomer() {
        Collections.sort(customers);
        System.out.println("--------------------------------------------------");
        for (Models.Customer customer : customers) {
            System.out.println(customer.showInfo());
        }
    }

    public List<Models.Customer> getCustomers() {
        return customers;
    }
}
