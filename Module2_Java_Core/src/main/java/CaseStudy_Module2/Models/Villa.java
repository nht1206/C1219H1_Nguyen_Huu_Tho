package CaseStudy_Module2.Models;

public class Villa extends Service {

    private String roomStandard;
    private String descriptionOfAmenities;
    private double areaOfPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberOfPeople, String typeOfRent, String roomStandard, String descriptionOfAmenities, double areaOfPool, int numberOfFloors) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.descriptionOfAmenities = descriptionOfAmenities;
        this.areaOfPool = areaOfPool;
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

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfo() {
        return "Villa: " + '\n' +
                "Id: " + super.getId() + '\n' +
                "Service Name: " + super.getServiceName() + '\n' +
                "Usable Area: " + super.getUsableArea() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Of Rent: " + super.getTypeOfRent()+ '\n' +
                "Room Standard: " + roomStandard + '\n' +
                "Convenient Description: " + descriptionOfAmenities + '\n' +
                "Area Pool: " + areaOfPool + '\n' +
                "Number Of Floors: " + numberOfFloors;
    }
}
