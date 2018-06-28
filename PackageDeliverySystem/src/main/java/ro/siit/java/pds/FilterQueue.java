package ro.siit.java.pds;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * In the filter queue packages are sorted alphabetically then prepared for assignment to a vehicle
 *
 * @param trackingID
 * @param packageAddDate
 * @return packageSort sorted alphabetically
 */
public class FilterQueue {
    private TreeSet<Parcel> deliveryQueue = new TreeSet<Parcel>(new Comparing());
    private TreeSet<Parcel> transportQueue = new TreeSet<Parcel>(new Comparing());

    class Comparing implements Comparator<Parcel> {
        @Override
        public int compare(Parcel p1, Parcel p2) {
            return p1.getDestinationCity().compareTo(p2.getDestinationCity());
        }
    }

    /**
     * Adds to a queue a package brought in by a car or a truck
     */
    public void addToQueue(Parcel parcel, Facility facility) {

        if (parcel.getDestinationCity().equalsIgnoreCase(facility.getFacilityCity()))
            deliveryQueue.add(parcel);
        else
            transportQueue.add(parcel);
    }


    /**
     * Removes from a queue a package to be lifted by a truck or a van
     *
     * @param packagesAssigned
     */
    public void removeFromQueue(Parcel[] packagesAssigned) {
    }


    public TreeSet<Parcel> getDeliveryQueue() {
        return deliveryQueue;
    }

    public TreeSet<Parcel> getTransportQueue() {
        return transportQueue;
    }
}
