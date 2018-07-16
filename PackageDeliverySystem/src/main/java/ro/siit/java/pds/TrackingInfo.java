package ro.siit.java.pds;

/**
 * This class is accessed by the Parcel class to determine the tracking history of the packages
 * @return getTrackingHistory
 */
public class TrackingInfo {

    public void printTrackingInfo(int trackingID) {

        PackageDeliverySystem pds = new PackageDeliverySystem();

        for (Parcel trackingParcel : pds.getPackages())
            if (trackingParcel.getTrackingID() == trackingID) {

                Address pickupAddress = trackingParcel.getSender().getAddress();
                Address deliveryAddress = trackingParcel.getDestination().getAddress();

                System.out.println("Tracking ID: " + trackingParcel.getTrackingID());
                System.out.println("Sender:");
                System.out.println("Name: " + trackingParcel.getSender().getContactName());
                System.out.println("Address: " + pickupAddress.getCountry() + ", " + trackingParcel.getSenderCity() + ", " + pickupAddress.getStreet() + ", " + pickupAddress.getZipCode());
                System.out.println("Telephone: " + trackingParcel.getSender().getPhoneNumber());

                System.out.println("Destination: ");
                System.out.println("Name: " + trackingParcel.getDestination().getContactName());
                System.out.println("Address: " + deliveryAddress.getCountry() + ", " + trackingParcel.getDestinationCity() + ", " + deliveryAddress.getStreet() + ", " + deliveryAddress.getZipCode());
                System.out.println("Telephone: " + trackingParcel.getDestination().getPhoneNumber());

                System.out.println("For the package we have the following tracking info:");
                System.out.println("1. Package picked up from " + trackingParcel.getSenderCity());
                System.out.println("2. Package entered " + trackingParcel.getSenderCity() + " Delivery Facility");
                System.out.println("3. Package departed " + trackingParcel.getSenderCity() + " Delivery Facility");
                System.out.println("4. Package entered " + trackingParcel.getDestinationCity() + " Delivery Facility");
                System.out.println("5. Package departed " + trackingParcel.getDestinationCity() + " Delivery Facility");
                System.out.println("6. Package delivered to " + trackingParcel.getSender().getContactName());
            }
    }
}
