package ro.siit.java.pds;

/**
 *The facility controls all the entries and exits of packages, manages the Filter Queue and assigns the vehicles needed for each operation
 *
 */
public class Facility {
    private String name;
    private Address facilityAddress;


    /**
     * Assigns the packages to the suitable transport vehicle
     * @param packages
     * @param vehicleID
     */
    public void assignVehicle (Parcel[] packages, String vehicleID){}

    public Address getFacilityAddress() {
        return facilityAddress;
    }

    public void setFacilityAddress(Address facilityAddress) {
        this.facilityAddress = facilityAddress;
    }

    public String getFacilityCity(){
        String facilityCity = facilityAddress.getCity();
        return facilityCity;
    }
}
