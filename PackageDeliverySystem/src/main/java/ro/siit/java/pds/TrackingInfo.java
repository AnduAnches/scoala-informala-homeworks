package ro.siit.java.pds;

/**
 * This class is accessed by the Parcel class to determine the tracking history of the packages
 * @param trackingInfo
 * @param parcel
 * @return getTrackingHistory
 */
public class TrackingInfo {
    public String trackingID;
    public Parcel parcel;

    public String[] getTrackingHistory(String trackingID, Parcel parcel) {
        return null;
    }
}
