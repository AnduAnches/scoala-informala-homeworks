package ro.siit.java.pds;

/**
 * The vehicles are used to pick up the packages, transport them and ultimately deliver them. Each vehicle has
 * @param vehicleID
 * @param vehicleCapacity the maximum no of packages a vehicle can transport
 * @param packagesAssigned the tracking ID's of the packages assigned to a vehicles
 */
public class Vehicle {
    private String vehicleID;
    private String type;
    private int vehicleCapacity;
    public Parcel[] packagesAssigned;
}
