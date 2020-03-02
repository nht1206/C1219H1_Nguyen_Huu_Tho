package CaseStudy_Module2.Controllers;

import CaseStudy_Module2.Views.Menu;

public class MainController {
    private Menu menu = new Menu();
    private ServiceController serviceController = new ServiceController();
    public void displayMainMenu() {
        int choice = menu.showMainMenu();
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
                addNewCustomers();
                break;
            }
            case 4: {
                showInfoCustomer();
                break;
            }
            case 5: {
                addNewBooking();
                break;
            }
            case 6: {
                showInfoEmployee();
                break;
            }
            case 7: {
                System.exit(0);
            }
            default: {
                displayMainMenu();
            }
        }
    }

    private void showServices() {
    }

    private void addNewCustomers() {
    }

    private void showInfoCustomer() {
    }

    private void addNewBooking() {
    }

    private void showInfoEmployee() {
    }

    private void addNewServices() {
        int choice = menu.showAddingMenu();
        switch (choice) {
            case 1: {
                serviceController.addListVillaService();
                break;
            }
            case 2: {
                serviceController.addListHouseService();
                break;
            }
            case 3: {
                serviceController.addListRoomService();
                break;
            }

            case 4: {
                displayMainMenu();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }
}
