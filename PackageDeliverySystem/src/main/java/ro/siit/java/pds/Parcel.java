package ro.siit.java.pds;

/**
 * One of the main classes in the project. It gathers information about the tracking information(tracking history), logistical information (route of the package, vehicle used) and sender and destination contact information
 *
 * @param trackingInfo
 * @param logisticalInfo
 * @param sender
 * @param destination
 */
public class Parcel {

    public TrackingInfo trackingInfo;
    public LogisticalInfo logisticalInfo;
    private ContactInfo sender;
    private ContactInfo destination;

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

    public String getDestinationCity() {
        String destinationCity = destination.getAddress().getCity();
        return destinationCity;
    }

}
