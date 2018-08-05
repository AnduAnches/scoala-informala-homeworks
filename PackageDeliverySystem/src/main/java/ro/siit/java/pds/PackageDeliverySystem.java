package ro.siit.java.pds;

import java.io.*;
import java.util.*;

public class PackageDeliverySystem {

    private Parcel packages[];

    private Parcel parcel = new Parcel();
    private ArrayList<Facility> facilities = new ArrayList<>();

    private ContactInfo pickupContactInfo = new ContactInfo();
    private Address pickupAddress = new Address();

    //destination info
    private ContactInfo destinationContactInfo = new ContactInfo();
    private Address destinationAddress = new Address();


    /**
     * reads the facilities from the Facilities.csv files, in order to verify the correctness of the data entered.
     *
     * @return an ArrayList with all the facilities
     */

    public final List<Facility> getFaclilities() {

        try {
            BufferedReader facilityReader = new BufferedReader(new FileReader("DB/Facilities.csv"));
            String line;
            while ((line = facilityReader.readLine()) != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                String city = tokens[2];
                Facility facility = new Facility();
                facility.setFacilityCity(city);
                facility.setName(name);
                facilities.add(facility);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    /**
     * collects the info entered by user from a keyboard and assigns it to the Parcel;
     */
    public void userData() {

        //hardcoded test data - will be replaced by user input in UI

        // sender info input
        pickupContactInfo.setContactName("Alex");
        pickupContactInfo.setPhoneNumber("445404");
        pickupAddress.setCity("cluj");
        pickupAddress.setStreet("Dorobanti 1");
        pickupAddress.setZipCode("346");

        //destination info input
        destinationContactInfo.setContactName("Ionut");
        destinationContactInfo.setPhoneNumber("987654");
        destinationAddress.setCity("iasi");
        destinationAddress.setStreet("Lapusneanu 3");
        destinationAddress.setZipCode("345");

        pickupContactInfo.setAddress(pickupAddress);
        destinationContactInfo.setAddress(destinationAddress);

        parcel.setSender(pickupContactInfo);
        parcel.setDestination(destinationContactInfo);
        parcel.setTrackingID(requestDeliveryPickup());

        transportPackage();

    }

    private Facility senderFacility = new Facility();
    private Facility destinationFacility = new Facility();
    //   private Facility destinationFacility = new Facility(destinationAddress.getCity());

    /**
     * The method that does the transportation of the package, since it is retrieved from the sender and delivered to the consignee.
     */
    private void transportPackage() {

        for (Facility facility : facilities) {
            String facilityCity = facility.getFacilityCity();
            senderFacility.setFacilityCity(pickupAddress.getCity());
            String senderFacilityCity = senderFacility.getFacilityCity();

            if (facilityCity.equalsIgnoreCase(senderFacilityCity)) {
                senderFacility.addPackagesToDB(parcel);

                Thread addPackageToFacility = new Thread(() -> {
                    senderFacility.pickUpPackage(parcel);
                    senderFacility.assignPackageToFacility(parcel);
                });

                Thread removePackageFromFacility = new Thread(() -> {
                    if (parcel.getSenderCity().equalsIgnoreCase(parcel.getDestinationCity())) {
                        senderFacility.deliverPackage(parcel);
                    } else {
                        senderFacility.transferPackage(parcel);
                    }
                });

                addPackageToFacility.run();
                try {
                    addPackageToFacility.join(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removePackageFromFacility.run();

                assignDestinationFacility();
                destinationFacility.deliverPackage(parcel);

            }
        }
    }

    /**
     * checks if the destination city entered by the user matches a facility city and assigns that facility as dest.
     *
     * @throws FacilityException
     */
    private void assignDestinationFacility() {

        for (Facility facility : facilities) {
            String facilityCity = facility.getFacilityCity();
            destinationFacility.setFacilityCity(destinationAddress.getCity());
            String destinationFacilityCity = destinationFacility.getFacilityCity();

            if (facilityCity.equalsIgnoreCase(destinationFacilityCity)) {
                destinationFacility.assignPackageToFacility(parcel);
            }
        }
    }


    /**
     * The function that assigns a tracking ID to the parcel and stores it in a .txt file
     */

    public int requestDeliveryPickup() {
        int trackingID = 0;
        try {
            BufferedReader trackingIDsRead = new BufferedReader(new FileReader("DB/trackingIDs.txt"));
            String currentLine;
            String lastTrackingID;

            while ((currentLine = trackingIDsRead.readLine()) != null) {
                lastTrackingID = currentLine;
                trackingID = Integer.parseInt(lastTrackingID) + 1;
            }

            BufferedWriter trackingIDsWrite = new BufferedWriter(new FileWriter("DB/trackingIDs.txt", true));
            trackingIDsWrite.write(String.valueOf(trackingID));
            trackingIDsWrite.newLine();
            trackingIDsWrite.flush();

            trackingIDsRead.close();
            trackingIDsWrite.close();

            return trackingID;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trackingID;
    }


    /**
     * This is the tracking information available to users: where is the package at a certain moment, when it left a certain facility, whe it's being delivered etc.
     *
     * @return the tracking information of the package
     */
    public void getTrackingInfo(int trackingID) {
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.printTrackingInfo(trackingID);

    }

    public void getLogisticalInfo(int trackingID) {
        LogisticalInfo logisticalInfo = new LogisticalInfo();
        logisticalInfo.getLogisticalInfo(trackingID);
    }

    /**
     * The information that admins will be able to see tracking info plus logistical info: the car transporting or delivering the package, the route established etc
     *
     * @return the tracking info + logistical info
     */
    public ArrayList<Parcel> getPackages() {

        FilterQueue filterQueue = new FilterQueue();

        for (Parcel filteredParcel : filterQueue.getDeliveryQueue()) {
            if (!filterQueue.getTransportQueue().contains(filteredParcel)) {
                filterQueue.getTransportQueue().add(filteredParcel);
            }
        }
        ArrayList<Parcel> allPackages = new ArrayList<>(filterQueue.getTransportQueue());
        return allPackages;
    }

    public Parcel getParcel() {
        return parcel;
    }
}
