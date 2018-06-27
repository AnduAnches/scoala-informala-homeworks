package ro.siit.java.pds;

/**
 * One of the main classes in the project. It gathers information about the tracking information(tracking history), logistical information (route of thye package, vehicle used) and sender and destination contact informations
 * @param trackingInfo
 * @param logisticalInfo
 * @param sender
 * @param destination
 */
public class Parcel {

    private TrackingInfo trackingInfo;
    private LogisticalInfo logisticalInfo;
    private ContactInfo sender;
    private ContactInfo destination;
}
