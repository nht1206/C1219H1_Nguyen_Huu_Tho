package Commons;

import Models.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReadWriteCSV {
    CSVWriter writer = null;
    private static final char COMMA_DELIMITER = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final String PATH_FILE_VILLA = "src/main/java/Data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/main/java/Data/House.csv";
    private static final String PATH_FILE_ROOM = "src/main/java/Data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/main/java/Data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/main/java/Data/Customer.csv";
    private static final String PATH_FILE_EMPLOYEE = "src/main/java/Data/Employee.csv";

    private static final String[] FILE_HEADER_OF_VILLA = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "areaOfPool", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_HOUSE = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_ROOM = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "freeServiceAccompany"};
    private static final String[] FILE_HEADER_OF_CUSTOMER = {"id", "nameCustomer", "idCard", "birthday", "gender", "phoneNumber", "email", "typeCustomer", "address"};
    private static final String[] FILE_HEADER_OF_BOOKING = {"idCustomer", "customerName", "idService", "serviceName"};
    private static final String[] FILE_HEADER_OF_EMPLOYEE = {"name", "age", "address"};


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
            List<String[]> allData = new ArrayList<>();
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
            List<String[]> allData = new ArrayList<>();
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

    public void writeCustomerToCSVFile(List<Customer> listCustomers) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_CUSTOMER), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_CUSTOMER);
            List<String[]> allData = new ArrayList<>();
            for (Customer customer : listCustomers) {
                String[] data = new String[]{
                        customer.getId(),
                        customer.getNameCustomer(),
                        customer.getIdCard(),
                        customer.getBirthday(),
                        customer.getGender(),
                        customer.getPhoneNumber(),
                        customer.getEmail(),
                        customer.getTypeCustomer(),
                        customer.getAddress()
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

    public void writeBookingToCSVFile(List<Booking> listBookings) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_BOOKING), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_BOOKING);
            List<String[]> allData = new ArrayList<>();
            for (Booking booking : listBookings) {
                String[] data = new String[]{
                        booking.getIdCustomer(),
                        booking.getCustomerName(),
                        booking.getIdService(),
                        booking.getServiceName()
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

    public List<Villa> readFileVillaCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_VILLA) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Villa> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Villa> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_VILLA));
            csvToBean = new CsvToBeanBuilder<Villa>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        return csvToBean.parse();
    }

    public List<House> readFileHouseCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_HOUSE) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<House> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<House> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_HOUSE));
            csvToBean = new CsvToBeanBuilder<House>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        return csvToBean.parse();
    }

    public List<Room> readFileRoomCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_ROOM) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Room> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Room> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_ROOM));
            csvToBean = new CsvToBeanBuilder<Room>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        return csvToBean.parse();
    }

    public List<Customer> readFileCustomerCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_CUSTOMER) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Customer> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Customer> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_CUSTOMER));
            csvToBean = new CsvToBeanBuilder<Customer>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        return csvToBean.parse();
    }

    public List<Booking> readFileBookingCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_BOOKING) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Booking> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Booking.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Booking> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_BOOKING));
            csvToBean = new CsvToBeanBuilder<Booking>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        return csvToBean.parse();
    }
    public Map<String, Employee> readFileEmployeeCSV() {
        Map<String, String> mapping = new HashMap<>();
        for (String s : FILE_HEADER_OF_EMPLOYEE) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Employee> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Employee> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_EMPLOYEE));
            csvToBean = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert csvToBean != null;
        Map<String, Employee> employeeMap = new HashMap<>();
        List<Employee> employees = csvToBean.parse();
        for (Employee employee : employees) {
            employeeMap.put("00" + employees.indexOf(employee), employee);
        }
        return employeeMap;
    }
}
