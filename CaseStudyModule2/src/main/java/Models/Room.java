package Models;

public class Room extends Service implements Comparable<Room> {
    private String freeServiceAccompany;

    public Room() {
    }

    public Room(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberOfPeople, String typeOfRent, String freeServiceAccompany) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberOfPeople, typeOfRent);
        this.freeServiceAccompany = freeServiceAccompany;
    }

    public String getFreeServiceAccompany() {
        return freeServiceAccompany;
    }

    public void setFreeServiceAccompany(String freeServiceAccompany) {
        this.freeServiceAccompany = freeServiceAccompany;
    }

    @Override
    public String showInfo() {
        return "Room:" + '\n' +
                "Id: " + super.getId() + '\n' +
                "Service Name: " + super.getServiceName() + '\n' +
                "Usable Area: " + super.getUsableArea() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Of Rent: " + super.getTypeOfRent() + '\n' +
                "Free Service Accompany: " + freeServiceAccompany;
    }

    @Override
    public int compareTo(Room o) {
        return getServiceName().compareTo(o.getServiceName());
    }
}
