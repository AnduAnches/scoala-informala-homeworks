package ro.siit.java.pds;

/**
 * This class stores the address information of users, facilities, destinations etc
 */
public class Address {

    private String city;
    private String street;
    private String zipCode;

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
