package Services;

import Commons.ReadWriteCSV;
import Models.House;
import Models.Room;
import Models.Villa;
import Validation.InputServiceValidation;

import java.util.*;

public class ResortServices {
    private Scanner scanner;
    private ReadWriteCSV readWriteCSV;
    private InputServiceValidation inputValidation;
    private List<Villa> villas;
    private List<House> houses;
    private List<Room> rooms;

    public ResortServices() {
        readWriteCSV = new ReadWriteCSV();
        inputValidation = new InputServiceValidation();
        villas = readWriteCSV.readFileVillaCSV();
        houses = readWriteCSV.readFileHouseCSV();
        rooms = readWriteCSV.readFileRoomCSV();
    }

    public void addListVillaService() {
        scanner = new Scanner(System.in);
        System.out.println("Enter number list villa you want: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            Villa villa = new Villa();
            villa.setId(getRandomUUID());
            villa.setServiceName(inputValidation.getValidNameService());
            villa.setUsableArea(inputValidation.getValidUsableArea());
            villa.setRentalCosts(inputValidation.getValidRentalCosts());
            villa.setMaxNumberOfPeople(inputValidation.getValidNumberOfPeople());
            villa.setTypeOfRent(inputValidation.getValidTypeOfRent());
            villa.setRoomStandard(inputValidation.getValidRoomStandard());
            System.out.print("Enter convenient description: ");
            villa.setDescriptionOfAmenities(scanner.nextLine());
            villa.setAreaOfPool(inputValidation.getValidPoolArea());
            villa.setNumberOfFloors(inputValidation.getNumberOfFloors());
            System.out.println("------------------------------------------------");
            villas.add(villa);
        }
        readWriteCSV.writeVillaToCSVFile(villas);
    }

    private String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void addListHouseService() {
        scanner = new Scanner(System.in);
        System.out.println("Enter number list villa you want: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            House house = new House();
            house.setId(getRandomUUID());
            house.setServiceName(inputValidation.getValidNameService());
            house.setUsableArea(inputValidation.getValidUsableArea());
            house.setRentalCosts(inputValidation.getValidRentalCosts());
            house.setMaxNumberOfPeople(inputValidation.getValidNumberOfPeople());
            house.setTypeOfRent(inputValidation.getValidTypeOfRent());
            house.setRoomStandard(inputValidation.getValidRoomStandard());
            System.out.print("Enter convenient description: ");
            house.setDescriptionOfAmenities(scanner.nextLine());
            house.setNumberOfFloors(inputValidation.getNumberOfFloors());
            System.out.println("------------------------------------------------");
            houses.add(house);
        }
        readWriteCSV.writeHouseToCSVFile(houses);
    }
    public void addListRoomService() {
        scanner = new Scanner(System.in);
        System.out.println("Enter number list villa you want: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            Room room = new Room();
            room.setId(getRandomUUID());
            room.setServiceName(inputValidation.getValidNameService());
            room.setUsableArea(inputValidation.getValidUsableArea());
            room.setRentalCosts(inputValidation.getValidRentalCosts());
            room.setMaxNumberOfPeople(inputValidation.getValidNumberOfPeople());
            room.setTypeOfRent(inputValidation.getValidTypeOfRent());
            System.out.println("Enter the service accompany: ");
            room.setFreeServiceAccompany(scanner.nextLine());
            System.out.println("------------------------------------------------");
            rooms.add(room);
        }
        readWriteCSV.writeRoomToCSVFile(rooms);
    }

    public void showVillaService() {
        for (Villa villa : villas) {
            System.out.println("--------------------------------------------------");
            System.out.println(villa.showInfo());
        }
    }

    public void showHouseService() {
        for (House house : houses) {
            System.out.println("--------------------------------------------------");
            System.out.println(house.showInfo());
        }
    }

    public void showRoomService() {
        for (Room room : rooms) {
            System.out.println("--------------------------------------------------");
            System.out.println(room.showInfo());
        }
    }

    public void showAllNameVillaNotDuplicate() {
        Set<Villa> villaTreeSet = new TreeSet<>(villas);
        for (Villa villa : villaTreeSet) {
            System.out.println("--------------------------------------------------");
            System.out.println(villa.getServiceName());
        }
    }

    public void showAllNameHouseNotDuplicate() {
        Set<House> houseTreeSet = new TreeSet<>(houses);
        for (House house : houseTreeSet) {
            System.out.println("--------------------------------------------------");
            System.out.println(house.getServiceName());
        }
    }

    public void showAllNameRoomNotDuplicate() {
        Set<Room> roomTreeSet = new TreeSet<>();
        roomTreeSet.addAll(rooms);
        for (Room room : roomTreeSet) {
            System.out.println("--------------------------------------------------");
            System.out.println(room.getServiceName());
        }
    }

    public List<Villa> getVillas() {
        return villas;
    }

    public List<House> getHouses() {
        return houses;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
