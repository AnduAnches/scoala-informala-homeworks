package ro.siit.java.pds;

/**
 *The facility controls all the entries and exits of packages, manages the Filter Queue and assigns the vehicles needed for each operation
 *
 */
public class Facility {
    private Address facilityAddress;
    private Parcel[] packages;
    private FilterQueue[] deliveryQueue;
    private FilterQueue[] transportQueue;
    private String[] vehicleID;


    /**
     * Adds to a queue a package brought in by a car or a truck
     * @param packagesAssigned
     */
    private void addToQueue (Parcel[] packagesAssigned){

    }

    /**
     * Removes from a queue a package to be lifted by a truck or a van
     * @param packagesAssigned
     */
    private void removeFromQueue (Parcel[] packagesAssigned){

    }


    /**
     * Assigns the packages to the suitable transport vehicle
     * @param packages
     * @param vehicleID
     */
    public void assignVehicle (Parcel[] packages, String vehicleID){
        return null;
    }
}
