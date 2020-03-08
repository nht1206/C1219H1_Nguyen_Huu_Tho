package Commons;

import Models.House;
import Models.Room;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;

public class TestOpenCSV {
    public static void main(String[] args) {
        //Test write villa
        ReadWriteCSV readWriteCSV = new ReadWriteCSV();
        List<Villa> listVillas = new ArrayList<>();
        Villa villa1 = new Villa("a1", "b1", 23.3, 646546.0, 3, "c1", "d1", "e1", 54.0, 3);
        listVillas.add(villa1);
        Villa villa2 = new Villa("a2", "b2", 24.3, 746546.0, 4, "c2", "d2", "e2", 64.0, 4);
        listVillas.add(villa2);
        Villa villa3 = new Villa("a3", "b3", 25.3, 846546.0, 5, "c3", "d3", "e3", 74.0, 5);
        listVillas.add(villa3);
        Villa villa4 = new Villa("a4", "b4", 26.3, 946546.0, 6, "c4", "d4", "e4", 84.0, 6);
        listVillas.add(villa4);
        readWriteCSV.writeVillaToCSVFile(listVillas);
        //Test write House
        List<House> listHouses = new ArrayList<>();
        House house1 = new House("a1", "b1", 23.3, 646546.0, 3, "c1", "d1", "e1", 3);
        listHouses.add(house1);
        House house2 = new House("a2", "b2", 24.3, 746546.0, 4, "c2", "d2", "e2", 4);
        listHouses.add(house2);
        House house3 = new House("a3", "b3", 25.3, 846546.0, 5, "c3", "d3", "e3", 5);
        listHouses.add(house3);
        House house4 = new House("a4", "b4", 26.3, 946546.0, 6, "c4", "d4", "e4", 6);
        listHouses.add(house4);
        readWriteCSV.writeHouseToCSVFile(listHouses);
        //Test write room
        List<Room> listRooms = new ArrayList<>();
        Room room1 = new Room("a1", "b1", 23.3, 646546.0, 3, "c1", "d1");
        listRooms.add(room1);
        Room room2 = new Room("a2", "b2", 24.3, 746546.0, 4, "c2", "d2");
        listRooms.add(room2);
        Room room3 = new Room("a3", "b3", 25.3, 846546.0, 5, "c3", "d3");
        listRooms.add(room3);
        Room room4 = new Room("a4", "b4", 26.3, 946546.0, 6, "c4", "d4");
        listRooms.add(room4);
        readWriteCSV.writeRoomToCSVFile(listRooms);
        listVillas = readWriteCSV.readFileVillaCSV();
        listHouses = readWriteCSV.readFileHouseCSV();
        listRooms = readWriteCSV.readFileRoomCSV();
        System.out.println("List villas read from Villa.csv");
        for (Villa v : listVillas) {
            System.out.println(v.showInfo());
        }
        System.out.println("List houses read from Villa.csv");
        for (House h : listHouses) {
            System.out.println(h.showInfo());
        }
        System.out.println("List rooms read from Villa.csv");
        for (Room r : listRooms) {
            System.out.println(r.showInfo());
        }
    }
}
