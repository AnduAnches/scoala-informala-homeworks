package ro.siit.java.pds;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the route calculation algorithm;
 * Testing if the correct route is displayed for routes between 2, 3 and 4 cities;
 * Testing if the user input is case-insensitive;
 * <p>
 * Not testing wrong user input (misspelled name). That exception will be defined in the Address class;
 */


class RouteCalculationTest {
    RouteCalculation testRoute = new RouteCalculation();


    // Testing if the route calculation displays correctly the route between 2 neighboring cities;
    @Test
    void setOptimalRouteTwoCities() {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Cluj");
        testList.add("Sibiu");

        assertEquals(testRoute.setOptimalRoute("Cluj", "Sibiu"), testList);
    }


    // Testing if the route calculation displays correctly the route between 3 cities;
    @Test
    void setOptimalRouteThreeCities() {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Cluj");
        testList.add("Sibiu");
        testList.add("Bucuresti");

        assertEquals(testRoute.setOptimalRoute("Cluj", "Bucuresti"), testList);
    }


    // Testing if the route calculation displays correctly the route between 4 cities;
    @Test
    void setOptimalRouteFourCities() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Cluj");
        testList.add("Sibiu");
        testList.add("Bucuresti");
        testList.add("Constanta");

        assertEquals(testRoute.setOptimalRoute("Cluj", "Constanta"), testList);
    }


    // Testing if the user input is case-insensitive;
    @Test
    void testCaseInsensitive() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Iasi");
        testList.add("Brasov");
        testList.add("Bucuresti");

        assertEquals(testRoute.setOptimalRoute("iAsI", "bucUrESti"), testList);
    }
}
