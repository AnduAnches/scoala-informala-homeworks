package ro.siit.java.pds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PackageDeliverySystem packageDeliverySystem = new PackageDeliverySystem();

        packageDeliverySystem.getFaclilities();

        System.out.println("Welcome to the courier system! Please select: 1. Place an order; 2. Check order status");

        Scanner userChoice = new Scanner(System.in);

        switch (userChoice.nextInt()) {
            case 1:
                packageDeliverySystem.userData();

                int trackingID = packageDeliverySystem.getParcel().getTrackingID();
                System.out.println("Your Tracking ID is: " + trackingID);
                break;

            case 2:
                System.out.println("Please insert a tracking Id:");
                int trackingInfoID = userChoice.nextInt();
                packageDeliverySystem.getTrackingInfo(trackingInfoID);
        }

        userChoice.close();
    }
}
