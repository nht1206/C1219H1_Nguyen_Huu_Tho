package CaseStudy_Module2.Views;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public int showMainMenu() {
        int choice;
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information Customer\n" +
                "5. Add New Booking Resort\n" +
                "6. Show Information Employee\n" +
                "7. Add booking cinema 4D\n" +
                "8. Show booking cinema 4D\n" +
                "9. Search Filing Cabinets of Employee\n" +
                "10. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        return choice;
    }
    public int showAddingMenu() {
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
}
