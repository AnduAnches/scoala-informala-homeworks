package ro.siit.java.pds;

/**
 * The vehicles are used to pick up the packages, transport them and ultimately deliver them. Each vehicle has
 *
 */

public class Vehicle {

    private String type;
    private int vehicleCapacity;
    public Parcel[] packagesAssigned;

    public Vehicle(String type) {

        switch (type.toLowerCase()) {
            case "car": {
                this.type = type;
                this.vehicleCapacity = 3;
                break;
            }
            case "van": {
                this.type = type;
                this.vehicleCapacity = 5;
                break;
            }
            case "truck": {
                this.type = type;
                this.vehicleCapacity = 10;
                break;
            }

        }
    }

    public String getType() {
        return type;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }
}
