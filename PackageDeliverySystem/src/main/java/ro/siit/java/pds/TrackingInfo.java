package ro.siit.java.pds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is accessed by the Parcel class to determine the tracking history of the packages
 *
 */
class TrackingInfo {


    void printTrackingInfo(int trackingID) {

        try {
            BufferedReader packageReader = new BufferedReader(new FileReader("DB/Packages.csv"));
            BufferedReader facilityReader = new BufferedReader(new FileReader("DB/Facilities.csv"));
            String line;
            String lineTwo;
            String sender = null;
            String destination = null;
            String senderCity = null;
            String destCity = null;

            while ((line = packageReader.readLine()) != null) {
                String[] tokens = line.split(",");

                if (trackingID == Integer.parseInt(tokens[0])) {

                    System.out.println("Tracking ID: " + tokens[0]);
                    System.out.println("Sender:");
                    System.out.println("Name: " + tokens[1]);
                    System.out.println("Address: " + tokens[2] + ", " + tokens[3] + ", " + tokens[4]);
                    System.out.println("Telephone: " + tokens[5]);

                    System.out.println("Destination: ");
                    System.out.println("Name: " + tokens[6]);
                    System.out.println("Address: " + tokens[7] + ", " + tokens[8] + ", " + tokens[9]);
                    System.out.println("Telephone: " + tokens[10]);

                    sender = tokens[1];
                    destination = tokens[6];
                    senderCity = tokens[2];
                    destCity = tokens[7];
                }
            }

            while ((lineTwo = facilityReader.readLine()) != null) {
                String[] tokensFacility = lineTwo.split(",");

                if (senderCity.equalsIgnoreCase(tokensFacility[2])) {
                    System.out.println("For the package we have the following tracking info:");
                    System.out.println("1. Package picked up from " + sender);
                    System.out.println("2. Package entered " + tokensFacility[0]);
                    System.out.println("3. Package departed " + tokensFacility[0]);
                }

                if (destCity.equalsIgnoreCase(tokensFacility[2])) {
                    System.out.println("4. Package entered " + tokensFacility[0]);
                    System.out.println("5. Package departed " + tokensFacility[0]);
                    System.out.println("6. Package delivered to " + destination);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

