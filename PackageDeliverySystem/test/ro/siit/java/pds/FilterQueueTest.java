package ro.siit.java.pds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



/**
 * Test class for the parcel sorting algorithm;
 * Testing if the parcel is added to the correct queue (TreeSet) for single and multi-package cases;
 * Testing if the parcels are sorted correctly in the queue - by the destination city;;
 * <p>
 * Not testing wrong user input (misspelled name). That exception will be defined in the Address class;
 */
class FilterQueueTest {

    /**
     * When the parcel's destination city and the facility's city are the same, the parcel will be placed in the delivery queue.
     * To test that, the delivery queue's size will be checked.
     *
     * @result deliveryQueue().size has to change from 0 to 1;
     */
    @Test
    void addToDeliveryQueue() {
        // given
        Parcel testParcel = new Parcel();
        ContactInfo testDestination = new ContactInfo();
        testParcel.setDestination(testDestination);
        Address testAddress = new Address();
        testDestination.setAddress(testAddress);

        Facility testFacility = new Facility();
        Address testFacilityAddress = new Address();
        testFacility.setFacilityAddress(testFacilityAddress);

        FilterQueue testFilterQueue = new FilterQueue();

        // when
        testAddress.setCity("Cluj");
        testFacilityAddress.setCity("Cluj");
        testFilterQueue.addToQueue(testParcel, testFacility);

        // then
        assertEquals(1, testFilterQueue.getDeliveryQueue().size());
    }

    /**
     * When the parcel's destination city and the facility's city are different, the parcel will be placed in the transport queue.
     * To test that, the transport queue's size will be checked.
     *
     * @result transportQueue().size has to change from 0 to 1;
     */
    @Test
    void addToTransportQueue() {
        // given
        Parcel testParcel = new Parcel();
        ContactInfo testDestination = new ContactInfo();
        testParcel.setDestination(testDestination);
        Address testAddress = new Address();
        testDestination.setAddress(testAddress);

        Facility testFacility = new Facility();
        Address testFacilityAddress = new Address();
        testFacility.setFacilityAddress(testFacilityAddress);

        FilterQueue testFilterQueue = new FilterQueue();

        // when
        testAddress.setCity("Cluj");
        testFacilityAddress.setCity("Bucuresti");
        testFilterQueue.addToQueue(testParcel, testFacility);

        // then
        assertEquals(1, testFilterQueue.getTransportQueue().size());
    }

    /**
     * Test with 3 parcels. One will have the destination city similar to the facility city, the other 2 wil have different cities;
     *
     * @result deliveryQueue().size has to change from 0 to 1;
     * @result transportQueue().size has to change from 0 to 2;
     */
    @Test
    void multipleParcelTest() {
        // given

        //first parcel
        Parcel testParcel = new Parcel();
        ContactInfo testDestination = new ContactInfo();
        testParcel.setDestination(testDestination);
        Address testAddress = new Address();
        testDestination.setAddress(testAddress);

        //second parcel
        Parcel testParcelTwo = new Parcel();
        ContactInfo testDestinationTwo = new ContactInfo();
        testParcelTwo.setDestination(testDestinationTwo);
        Address testAddressTwo = new Address();
        testDestinationTwo.setAddress(testAddressTwo);

        //third parcel
        Parcel testParcelThree = new Parcel();
        ContactInfo testDestinationThree = new ContactInfo();
        testParcelThree.setDestination(testDestinationThree);
        Address testAddressThree = new Address();
        testDestinationThree.setAddress(testAddressThree);

        //facility
        Facility testFacility = new Facility();
        Address testFacilityAddress = new Address();
        testFacility.setFacilityAddress(testFacilityAddress);

        //filter queue
        FilterQueue testFilterQueue = new FilterQueue();

        // when
        testAddress.setCity("Cluj");
        testAddressTwo.setCity("Brasov");
        testAddressThree.setCity("Iasi");
        testFacilityAddress.setCity("Cluj");
        testFilterQueue.addToQueue(testParcel, testFacility);
        testFilterQueue.addToQueue(testParcelTwo, testFacility);
        testFilterQueue.addToQueue(testParcelThree, testFacility);

        // then
        assertEquals(1, testFilterQueue.getDeliveryQueue().size());
        assertEquals(2, testFilterQueue.getTransportQueue().size());
    }

    /**
     * Test with 3 parcels. All 3 parcels will go in the transport queue.
     *
     * @result deliveryQueue().size is zero;
     * @result transportQueue().size has to change from 0 to 3;
     * @result Parcels to be sorted alphabetically according to the destination city;
     */
    @Test
    void sortedParcelTest() {
        // given

        //first parcel
        Parcel testParcel = new Parcel();
        ContactInfo testDestination = new ContactInfo();
        testParcel.setDestination(testDestination);
        Address testAddress = new Address();
        testDestination.setAddress(testAddress);

        //second parcel
        Parcel testParcelTwo = new Parcel();
        ContactInfo testDestinationTwo = new ContactInfo();
        testParcelTwo.setDestination(testDestinationTwo);
        Address testAddressTwo = new Address();
        testDestinationTwo.setAddress(testAddressTwo);

        //third parcel
        Parcel testParcelThree = new Parcel();
        ContactInfo testDestinationThree = new ContactInfo();
        testParcelThree.setDestination(testDestinationThree);
        Address testAddressThree = new Address();
        testDestinationThree.setAddress(testAddressThree);

        //facility
        Facility testFacility = new Facility();
        Address testFacilityAddress = new Address();
        testFacility.setFacilityAddress(testFacilityAddress);

        //filter queue
        FilterQueue testFilterQueue = new FilterQueue();

        // when
        testAddress.setCity("Sibiu");
        testAddressTwo.setCity("Brasov");
        testAddressThree.setCity("Iasi");
        testFacilityAddress.setCity("Cluj");

        testFilterQueue.addToQueue(testParcel, testFacility);
        testFilterQueue.addToQueue(testParcelTwo, testFacility);
        testFilterQueue.addToQueue(testParcelThree, testFacility);

        String expectedCityOrder[] = {"Brasov", "Iasi", "Sibiu"};

        // then

        String[] actualCityOrder = new String[3];
        int i = 0;
        for (Parcel test : testFilterQueue.getTransportQueue()) {
            actualCityOrder[i] = test.getDestinationCity();
            i++;
        }

        assertEquals(0, testFilterQueue.getDeliveryQueue().size());
        assertEquals(3, testFilterQueue.getTransportQueue().size());

        for (int j = 0; j < 3; j++) {
            assertEquals(0, expectedCityOrder[j].compareTo(actualCityOrder[j]));
        }
    }

}