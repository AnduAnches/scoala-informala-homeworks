package ro.siit.java.pds;

public class PackageDeliverySystem {

    private Parcel packages[];

    /**
     * The user will request a package pick-up, inserting the names and addresses for pick-up and delivery;
     *
     * @param pickupContactInfo
     * @param deliveryContactInfo
     * @return the tracking id of the delivery
     */
    public String requestDeliveryPickup(ContactInfo pickupContactInfo, ContactInfo deliveryContactInfo) {
        return null;
    }

    /**
     * This is the tracking information available to users: where is the package at a certain moment, when it left a certain facility, whe it's being delivered etc.
     * @param trackingId
     * @return the tracking information of the package
     */
    public TrackingInfo getTrackingInfo(String trackingId){
        return null;
    }

    /**
     * The information that admins will be able to see = tracking info plus logistical info: the car transporting or delivering the package, the route established etc
     * @param admin
     * @return the tracking info + logistical info
     */
    public Parcel[] getPackages(Administrator admin){
        return null;
    }

}
