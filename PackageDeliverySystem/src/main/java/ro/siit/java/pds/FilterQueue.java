package ro.siit.java.pds;

import java.util.Calendar;

/**
 * In the filter queue packages are sorted alphabetically then prepared for assignment to a vehicle according to their aging (first in, first out)
 * @param trackingID
 * @param packageAddDate
 * @return packageSort sorted alphabetically
 * @return packageAging determine what packages have the longest stay in the queue
 */
public class FilterQueue {

    public String trackingID;
    private Calendar packageAddDate;

    private Parcel[] packageSort (ContactInfo pickupContactInfo, ContactInfo deliveryContactInfo){
        return null;
    }

    private Parcel[] packageAging(Calendar packageAddDate, String trackingID ){
        return null;
    }
}
