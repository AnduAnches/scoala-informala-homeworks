package ro.siit.java.pds;

/**
 * This class stores the address information of users, facilities, destinations etc
 * @param country
 * @param city
 * @param street
 * @param zipCode
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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
