package ro.siit.java.pds;

import java.io.*;
import java.util.*;

public class PackageDeliverySystem {

    private Parcel packages[];


    private Parcel parcel = new Parcel();

    private ContactInfo pickupContactInfo = new ContactInfo();
    private Address pickupAddress = new Address();

    //destination info
    private ContactInfo destinationContactInfo = new ContactInfo();
    private Address destinationAddress = new Address();
    private ArrayList<Facility> facilities = new ArrayList<>();

    /**
     * reads the facilities from the Facilities.csv files, in order to verify the correctness of the data entered.
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
                Facility facility = new Facility(city);
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
        //sender info

        Scanner userInput = new Scanner(System.in);

        //sender info input
        System.out.println("Please insert sender name: ");
        pickupContactInfo.setContactName(userInput.next());

        System.out.println("Please insert sender phone no.: ");
        pickupContactInfo.setPhoneNumber(userInput.next());

        System.out.println("Please insert sender city: ");
        pickupAddress.setCity(userInput.next());

        System.out.println("Please insert sender street address: ");
        pickupAddress.setStreet(userInput.next());

        System.out.println("Please insert sender zip code: ");
        pickupAddress.setZipCode(userInput.next());

        //destination info input

        System.out.println("Please insert consignee name: ");
        destinationContactInfo.setContactName(userInput.next());

        System.out.println("Please insert consignee phone no.: ");
        destinationContactInfo.setPhoneNumber(userInput.next());

        System.out.println("Please insert destination city: ");
        destinationAddress.setCity(userInput.next());

        System.out.println("Please insert destination street address: ");
        destinationAddress.setStreet(userInput.next());

        System.out.println("Please insert destination zip code: ");
        destinationAddress.setZipCode(userInput.next());

        userInput.close();

        pickupContactInfo.setAddress(pickupAddress);
        destinationContactInfo.setAddress(destinationAddress);

        parcel.setSender(pickupContactInfo);
        parcel.setDestination(destinationContactInfo);
        parcel.setTrackingID(requestDeliveryPickup(pickupContactInfo, destinationContactInfo));

        try {
            assignSenderFacility();
            assignDestinationFacility();
        } catch (FacilityException e) {
            e.printStackTrace();
        }

    }

    /**
     * checks if the city entered by the user matches a facility city and assigns that facility as sender
     * @throws FacilityException
     */
    private void assignSenderFacility() throws FacilityException {
        Facility senderFacility = new Facility(pickupAddress.getCity());
        if (facilities.contains(senderFacility))
            senderFacility.assignPackage();
        else throw new FacilityException();
    }

    /**
     * checks if the destination city entered by the user matches a facility city and assigns that facility as dest.
     * @throws FacilityException
     */
    private void assignDestinationFacility() throws FacilityException {

        Facility destinationFacility = new Facility(destinationAddress.getCity());
        if (!facilities.contains(destinationFacility))
            throw new FacilityException();
    }


    /**
     * The function that assigns a tracking ID to the parcel and stores it in a .txt file
     *
     */

    public int requestDeliveryPickup(ContactInfo pickupContactInfo, ContactInfo deliveryContactInfo) {
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


    public ContactInfo getPickupContactInfo() {
        return pickupContactInfo;
    }

    public ContactInfo getDestinationContactInfo() {
        return destinationContactInfo;
    }

    public Parcel getParcel() {
        return parcel;
    }
}
