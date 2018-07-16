package ro.siit.java.pds;

/**
 * The facility controls all the entries and exits of packages, manages the Filter Queue and assigns the vehicles needed for each operation
 */
public class Facility {
    private String name;
    private Address facilityAddress;

    public Facility(String city) {
         this.facilityAddress.setCity(city);
    }

    private FilterQueue filterQueue = new FilterQueue();
    private PackageDeliverySystem pds = new PackageDeliverySystem();

    /**
     * Assigns the package to the right queue in the right facility;
     */
    public void assignPackage() {

        filterQueue.addToQueue(pds.getParcel(), Facility.this);

    }

    /**
     * Assigns the packages to the suitable transport vehicle
     *
     * @param packages
     * @param vehicleID
     */
    public void assignVehicle(Parcel[] packages, String vehicleID) {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacilityAddress(Address facilityAddress) {
        this.facilityAddress = facilityAddress;
    }

    public String getFacilityCity() {
        String facilityCity = facilityAddress.getCity();
        return facilityCity;
    }

}
