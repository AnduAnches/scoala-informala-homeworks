package ro.siit.java.pds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The facility controls all the entries and exits of packages, manages the Filter Queue and assigns the vehicles needed for each operation
 */
public class Facility {
    private String name;
    private Address facilityAddress = new Address();

//    public Facility(String city) {
//        this.facilityAddress.setCity(city);
//    }

    private FilterQueue filterQueue = new FilterQueue();
    private Vehicle carOne = new Vehicle("car");
    private Vehicle truckOne = new Vehicle("truck");
    private Vehicle vanOne = new Vehicle("van");


    /**
     * The package gets picked up from the customer by a car
     * @param parcel
     */
    public void pickUpPackage(Parcel parcel) {
        carOne.retreivePackage(parcel);
        carOne.deliverPackage(parcel);
    }

    /**
     * Assigns the package to the right queue in the right facility;
     */
    public void assignPackageToFacility(Parcel parcel) {
        filterQueue.addToQueue(parcel, Facility.this);
    }

    public void deliverPackage(Parcel parcel) {

        if (Facility.this.getFacilityCity().equalsIgnoreCase(parcel.getDestinationCity())) {
            filterQueue.removeFromDeliveryQueue(parcel);
            vanOne.retreivePackage(parcel);
            vanOne.deliverPackage(parcel);
        }
    }

    public void transferPackage(Parcel parcel) {

        if (!Facility.this.getFacilityCity().equalsIgnoreCase(parcel.getDestinationCity())) {
            filterQueue.removeFromTransportQueue(parcel);
            truckOne.retreivePackage(parcel);
            truckOne.deliverPackage(parcel);
        }
    }


    public void addPackagesToDB(Parcel parcel) {

        try {

            BufferedWriter packagesWrite = new BufferedWriter(new FileWriter("DB/Packages.csv", true));
            packagesWrite.write(
                    parcel.getTrackingID() + "," +
                            parcel.getSender().getContactName() + "," +
                            parcel.getSenderCity() + "," +
                            parcel.getSender().getAddress().getStreet() + "," +
                            parcel.getSender().getAddress().getZipCode() + "," +
                            parcel.getSender().getPhoneNumber() + "," +
                            parcel.getDestination().getContactName() + "," +
                            parcel.getDestinationCity() + "," +
                            parcel.getDestination().getAddress().getStreet() + "," +
                            parcel.getDestination().getAddress().getZipCode() + "," +
                            parcel.getDestination().getPhoneNumber()
            );
            packagesWrite.newLine();
            packagesWrite.flush();

            packagesWrite.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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


    public void setFacilityCity(String city) {
        facilityAddress.setCity(city);
    }

    public String getFacilityCity() {
        String facilityCity = facilityAddress.getCity();
        return facilityCity;
    }

}
