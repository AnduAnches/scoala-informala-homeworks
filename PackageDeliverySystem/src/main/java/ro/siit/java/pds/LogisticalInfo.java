package ro.siit.java.pds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogisticalInfo {

    /**
     * Obtains the logistical informations about the package: where the package is located, what type of vehicle is transporting the package, what route has been taken
     *
     * @param trackingID
     * @param facilityInfo
     * @param routeInfo
     * @return
     */
    public void getLogisticalInfo(int trackingID) {

        PackageDeliverySystem pds = new PackageDeliverySystem();

        for (Parcel trackingParcel : pds.getPackages())
            if (trackingParcel.getTrackingID() == trackingID) {

                RouteCalculation routeCalculation = new RouteCalculation();
                List<String> route = routeCalculation.setOptimalRoute(trackingParcel.getSenderCity(), trackingParcel.getDestinationCity());

                Iterator<String> iterator = route.iterator();
                int i = 0;
                while (iterator.hasNext()) {

                    if (route.get(i).equalsIgnoreCase(trackingParcel.getSenderCity())) {
                        System.out.println("Between " + trackingParcel.getSender().getContactName() + " and " + trackingParcel.getSenderCity() +
                                " a " + (new Vehicle("car")).getType() + " picks up the package and takes it to the local facility called " + trackingParcel.getSenderCity() + " Delivery Facility.");
                    } else if (route.get(i).equalsIgnoreCase(trackingParcel.getDestinationCity())) {
                        System.out.println("Between " + trackingParcel.getDestinationCity() + " Delivery Facility and " + trackingParcel.getDestination().getContactName() +
                                " a " + (new Vehicle("van").getType()) + " delivers the package from the facility to the destination.");
                    } else {
                        System.out.println("Between " + route.get(i) + " and " + route.get(i + 1) + " a " + (new Vehicle("truck").getType() + " delivers the package."));
                    }

                    i++;
                }
            }
    }
}
