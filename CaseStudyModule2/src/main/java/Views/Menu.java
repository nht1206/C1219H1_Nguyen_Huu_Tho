package Views;

import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int displayMainMenu() {
        int choice;
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information Customer\n" +
                "5. Add New Booking Resort\n" +
                "6. Show Information Employee\n" +
                "7. Booking the cinema ticket.\n" +
                "8. Show booking the cinema ticket. \n" +
                "9. Find employee. \n" +
                "10. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        return choice;
    }

    public int displayAddingServiceMenu() {
        int choice;
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit");
        System.out.print("Input your choice: ");
        choice = scanner.nextInt();
        return choice;
    }

    public int displayShowingServiceMenu() {
        int choice;
        System.out.println("1. Show All Villa\n" +
                "2. Show All House\n" +
                "3. Show All Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        return choice;
    }

    public int displayBookingMenu() {
        int choice;
        System.out.println("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        return choice;
    }
}
