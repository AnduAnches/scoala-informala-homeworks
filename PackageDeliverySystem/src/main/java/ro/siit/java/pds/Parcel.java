package ro.siit.java.pds;

/**
 * One of the main classes in the project. It gathers information about the tracking information(tracking history), logistical information (route of the package, vehicle used) and sender and destination contact information
 *
 */
public class Parcel {

    private int trackingID;
    private ContactInfo sender;
    private ContactInfo destination;

    public int getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(int trackingID) {
        this.trackingID = trackingID;
    }

    public ContactInfo getSender() {
        return sender;
    }

    public void setSender(ContactInfo sender) {
        this.sender = sender;
    }

    public ContactInfo getDestination() {
        return destination;
    }

    public void setDestination(ContactInfo destination) {
        this.destination = destination;
    }

    public String getSenderCity() {
        String senderCity = sender.getAddress().getCity();
        return senderCity;
    }

    public String getDestinationCity() {
        String destinationCity = destination.getAddress().getCity();
        return destinationCity;
    }

}
