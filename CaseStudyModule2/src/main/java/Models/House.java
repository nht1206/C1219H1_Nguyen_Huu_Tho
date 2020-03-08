package Models;

public class House extends Service implements Comparable<House> {
    private String roomStandard;
    private String descriptionOfAmenities;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberOfPeople, String typeOfRent, String roomStandard, String descriptionOfAmenities, int numberOfFloors) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.descriptionOfAmenities = descriptionOfAmenities;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOfAmenities() {
        return descriptionOfAmenities;
    }

    public void setDescriptionOfAmenities(String descriptionOfAmenities) {
        this.descriptionOfAmenities = descriptionOfAmenities;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfo() {
        return "House: " + '\n' +
                "Id: " + super.getId() + '\n' +
                "Service Name: " + super.getServiceName() + '\n' +
                "Usable Area: " + super.getUsableArea() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Of Rent: " + super.getTypeOfRent()+ '\n' +
                "Room Standard: " + roomStandard + '\n' +
                "Description Of Amenities:  " + descriptionOfAmenities + '\n' +
                "Number Of Floors: " + numberOfFloors;
    }

    @Override
    public int compareTo(House o) {
        return getServiceName().compareTo(o.getServiceName());
    }
}
