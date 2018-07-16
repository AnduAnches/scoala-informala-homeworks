package ro.siit.java.pds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the courier system! Please select: 1. Place an order; 2. Check order status");

        Scanner userChoice = new Scanner(System.in);

        switch (userChoice.nextInt()) {
            case 1:

                PackageDeliverySystem packageDeliverySystem = new PackageDeliverySystem();

                packageDeliverySystem.userData();

                ContactInfo pickupContactInfo = packageDeliverySystem.getPickupContactInfo();
                ContactInfo destinationContactInfo = packageDeliverySystem.getDestinationContactInfo();
                int trackingID = packageDeliverySystem.requestDeliveryPickup(pickupContactInfo, destinationContactInfo);
                System.out.println("Your Tracking ID is: " + trackingID);
                break;

            case 2:

                }


    }
}
