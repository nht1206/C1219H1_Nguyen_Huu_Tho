package Controllers;

import Commons.ReadWriteCSV;
import Models.*;
import Services.CinemaServices;
import Services.CustomerServices;
import Services.FileCabinetServices;
import Services.ResortServices;
import Views.Menu;

import java.util.*;

public class MainController {
    private Menu menu = new Menu();
    private ResortServices resortServices;
    private CustomerServices customerServices;
    private Scanner scanner;
    private ReadWriteCSV readWriteCSV;
    private CinemaServices cinemaServices;
    private FileCabinetServices fileCabinetServices;

    public MainController() {
        resortServices = new ResortServices();
        customerServices = new CustomerServices();
        readWriteCSV = new ReadWriteCSV();
        scanner = new Scanner(System.in);
        cinemaServices = new CinemaServices();
        fileCabinetServices = new FileCabinetServices();
    }

    public void displayMainMenu() {
        int choice = menu.displayMainMenu();
        switch (choice) {
            case 1: {
                addNewServices();
                break;
            }
            case 2: {
                showServices();
                break;
            }
            case 3: {
                customerServices.addNewCustomers();
                displayMainMenu();
                break;
            }
            case 4: {
                customerServices.showInfoCustomer();
                displayMainMenu();
                break;
            }
            case 5: {
                addNewBooking();
                displayMainMenu();
                break;
            }
            case 6: {
                showInfoEmployee();
                displayMainMenu();
                break;
            }
            case 7: {
                bookCinemaTicket();
                displayMainMenu();
                break;
            }
            case 8: {
                showBookingCinemaTicket();
                displayMainMenu();
                break;
            }
            case 9: {
                findEmployee();
                displayMainMenu();
                break;
            }
            case 10: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                displayMainMenu();
            }
        }
    }

    private void findEmployee() {
        scanner = new Scanner(System.in);
        System.out.print("Enter id of Employee: ");
        String idEmployee = scanner.nextLine();
        Employee employee = fileCabinetServices.findEmployeeById(idEmployee);
        if (employee == null) {
            System.out.println("Not found Filing Cabinets!");
        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.println(employee);
            System.out.println("----------------------------------------------------------------");
        }
    }

    private void showBookingCinemaTicket() {
        Queue<Customer> customers = cinemaServices.getAllBookingCinema();
        while (true) {
            Customer customer = customers.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer.showInfo());
        }
    }

    private void bookCinemaTicket() {
        List<Models.Customer> listCustomers = customerServices.getCustomers();
        scanner = new Scanner(System.in);
        System.out.println("Enter number ticket: ");
        int numberOfTicket = scanner.nextInt();
        while (numberOfTicket < 1) {
            System.out.println("Số lượng vé phải là số dương");
        }
        int choice;
        for (int i = 0; i < numberOfTicket; i++) {
            System.out.println("Choose the customer: ");
            for (Models.Customer customer : listCustomers) {
                System.out.println(listCustomers.indexOf(customer) + ": " + customer.getNameCustomer());
            }
            choice = scanner.nextInt();
            Models.Customer selectedCustomer;
            if (choice >= listCustomers.size()) {
                System.out.println("out of size.");
                i--;

            } else {
                selectedCustomer = listCustomers.get(choice);
                cinemaServices.addBookingCinema(selectedCustomer);
            }
        }
    }

    private void showServices() {
        int choice = menu.displayShowingServiceMenu();
        switch (choice) {
            case 1: {
                resortServices.showVillaService();
                showServices();
                break;
            }
            case 2: {
                resortServices.showHouseService();
                showServices();
                break;
            }
            case 3: {
                resortServices.showRoomService();
                showServices();
                break;
            }
            case 4: {
                resortServices.showAllNameVillaNotDuplicate();
                showServices();
                break;
            }
            case 5: {
                resortServices.showAllNameHouseNotDuplicate();
                showServices();
                break;
            }
            case 6: {
                resortServices.showAllNameRoomNotDuplicate();
                showServices();
                break;
            }

            case 7: {
                displayMainMenu();
                break;
            }
            case 8: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                showServices();
            }
        }
    }


    private void addNewBooking() {
        List<Models.Customer> listCustomers = customerServices.getCustomers();
        int choice;
        System.out.println("Choose the customer: ");
        for (Models.Customer customer : listCustomers) {
            System.out.println(listCustomers.indexOf(customer) + ": " + customer.getNameCustomer());
        }
        choice = scanner.nextInt();
        Models.Customer selectedCustomer = null;
        if (choice >= listCustomers.size()) {
            System.out.println("out of size.");
            addNewBooking();
        } else {
            selectedCustomer = listCustomers.get(choice);
        }
        choice = menu.displayBookingMenu();
        Models.Service selectedService = null;
        switch (choice) {
            case 1:
                List<Villa> villas = resortServices.getVillas();
                if (villas.size() == 0) {
                    System.out.println("List villa is empty.");
                    addNewBooking();
                }
                for (Villa villa : villas) {
                    System.out.println(villas.indexOf(villa) + ": " + villa.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > villas.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = villas.get(choice);
                }
                break;
            case 2:
                List<House> houses = resortServices.getHouses();
                if (houses.size() == 0) {
                    System.out.println("List house is empty.");
                    addNewBooking();
                }
                for (House house : houses) {
                    System.out.println(houses.indexOf(house) + ": " + house.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > houses.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = houses.get(choice);
                }
                break;
            case 3:
                List<Room> rooms = resortServices.getRooms();
                if (rooms.size() == 0) {
                    System.out.println("List room is empty.");
                    addNewBooking();
                }
                for (Room room : rooms) {
                    System.out.println(rooms.indexOf(room) + ": " + room.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > rooms.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = rooms.get(choice);
                }
                break;
            default:
                System.out.println("There is not this option.");
        }
        assert selectedCustomer != null;
        List<Booking> bookings = readWriteCSV.readFileBookingCSV();
        Booking newBooking = new Booking();
        newBooking.setIdCustomer(selectedCustomer.getId());
        newBooking.setCustomerName(selectedCustomer.getNameCustomer());
        assert selectedService != null;
        newBooking.setIdService(selectedService.getId());
        newBooking.setServiceName(selectedService.getServiceName());
        bookings.add(newBooking);
        readWriteCSV.writeBookingToCSVFile(bookings);
        displayMainMenu();
    }

    private void showInfoEmployee() {
        Map<String, Employee> employeeMap = readWriteCSV.readFileEmployeeCSV();
        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
            System.out.println("------------------------------------------------");
        }
    }

    private void addNewServices() {
        int choice = menu.displayAddingServiceMenu();
        switch (choice) {
            case 1: {
                resortServices.addListVillaService();
                addNewServices();
                break;
            }
            case 2: {
                resortServices.addListHouseService();
                addNewServices();
                break;
            }
            case 3: {
                resortServices.addListRoomService();
                addNewServices();
                break;
            }

            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                addNewServices();
            }
        }
    }

}
