package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.House;
import CaseStudy_Module2.Models.Room;
import CaseStudy_Module2.Models.Villa;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSV {
    CSVWriter writer = null;
    private final char COMMA_DELIMITER = ',';
    private final char DEFAULT_QUOTE = '"';
    private final String NEW_LINE_SEPARATOR = "\n";
    private final int NUM_OF_LINE_SKIP = 1;
    private final String PATH_FILE_VILLA = "src/main/java/CaseStudy_Module2/Data/Villa.csv";
    private final String PATH_FILE_HOUSE = "src/main/java/CaseStudy_Module2/Data/House.csv";
    private final String PATH_FILE_ROOM = "src/main/java/CaseStudy_Module2/Data/Room.csv";
    private final String PATH_FILE_CUSTOMER = "src/main/java/CaseStudy_Module2/Customer.csv";
    private final String[] FILE_HEADER_OF_VILLA = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "areaOfPool", "numberOfFloors"};
    private final String[] FILE_HEADER_OF_HOUSE = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "numberOfFloors"};
    private final String[] FILE_HEADER_OF_ROOM = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "freeServiceAccompany"};
    private final String[] FILE_HEADER_OF_CUSTOMER = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address"};

    public void writeVillaToCSVFile(List<Villa> listVillas) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_VILLA), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_VILLA);
            List<String[]> allData = new ArrayList<String[]>();
            for (Villa villa : listVillas) {
                String[] data = new String[]{
                        villa.getId() + "",
                        villa.getServiceName() + "",
                        villa.getUsableArea() + "",
                        villa.getRentalCosts() + "",
                        villa.getMaxNumberOfPeople() + "",
                        villa.getTypeOfRent() + "",
                        villa.getRoomStandard() + "",
                        villa.getDescriptionOfAmenities() + "",
                        villa.getAreaOfPool() + "",
                        villa.getNumberOfFloors() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public void writeHouseToCSVFile(List<House> listHouses) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_HOUSE), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_HOUSE);
            List<String[]> allData = new ArrayList<String[]>();
            for (House house : listHouses) {
                String[] data = new String[]{
                        house.getId() + "",
                        house.getServiceName() + "",
                        house.getUsableArea() + "",
                        house.getRentalCosts() + "",
                        house.getMaxNumberOfPeople() + "",
                        house.getTypeOfRent() + "",
                        house.getRoomStandard() + "",
                        house.getDescriptionOfAmenities() + "",
                        house.getNumberOfFloors() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public void writeRoomToCSVFile(List<Room> listRooms) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_ROOM), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_ROOM);
            List<String[]> allData = new ArrayList<String[]>();
            for (Room room : listRooms) {
                String[] data = new String[]{
                        room.getId() + "",
                        room.getServiceName() + "",
                        room.getUsableArea() + "",
                        room.getRentalCosts() + "",
                        room.getMaxNumberOfPeople() + "",
                        room.getTypeOfRent() + "",
                        room.getFreeServiceAccompany() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
