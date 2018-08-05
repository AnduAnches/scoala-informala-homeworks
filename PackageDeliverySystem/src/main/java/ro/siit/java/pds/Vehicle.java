package ro.siit.java.pds;

import java.util.ArrayList;

/**
 * The vehicles are used to pick up the packages, transport them and ultimately deliver them. Each vehicle has
 */

public class Vehicle {

    private String type;
    private ArrayList<Parcel> packagesAssigned = new ArrayList<>();

    public Vehicle(String type) {

        switch (type.toLowerCase()) {
            case "car": {
                this.type = type;
                break;
            }
            case "van": {
                this.type = type;
                break;
            }
            case "truck": {
                this.type = type;
                break;
            }

        }
    }

    public String getType() {
        return type;
    }


    public void retreivePackage(Parcel parcel) {
        packagesAssigned.add(parcel);
    }

    public void deliverPackage(Parcel parcel) {
        packagesAssigned.remove(parcel);
    }
}

