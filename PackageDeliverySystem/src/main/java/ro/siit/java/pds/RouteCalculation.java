package ro.siit.java.pds;

import java.util.ArrayList;
import java.util.List;

/**
 * The route calculation class, which will decide the optimal route between the sender and consignee
 *
 */
public class RouteCalculation {
    /**
     *the route calculation with the Dijkstra algorithm
     * @param senderCity
     * @param destinationCity
     * @return routeCities  the list of all the cities on the route, including the sender and destination
     */
    public List setOptimalRoute(String senderCity, String destinationCity) {


        Node cluj = new Node("Cluj");
        Node sibiu = new Node("Sibiu");
        Node brasov = new Node("Brasov");
        Node iasi = new Node("Iasi");
        Node bucuresti = new Node("Bucuresti");
        Node constanta = new Node("Constanta");

        cluj.addDestination(sibiu, 172);
        cluj.addDestination(brasov, 273);
        cluj.addDestination(iasi, 418);
        sibiu.addDestination(cluj, 172);
        sibiu.addDestination(bucuresti, 271);
        sibiu.addDestination(brasov, 142);
        brasov.addDestination(cluj, 273);
        brasov.addDestination(sibiu, 142);
        brasov.addDestination(iasi, 305);
        brasov.addDestination(bucuresti, 184);
        iasi.addDestination(cluj, 418);
        iasi.addDestination(constanta, 414);
        iasi.addDestination(brasov, 305);
        bucuresti.addDestination(sibiu, 271);
        bucuresti.addDestination(brasov, 184);
        bucuresti.addDestination(constanta, 224);
        constanta.addDestination(bucuresti, 224);
        constanta.addDestination(iasi, 414);

        Graph graph = new Graph();

        graph.addNode(cluj);
        graph.addNode(sibiu);
        graph.addNode(brasov);
        graph.addNode(iasi);
        graph.addNode(bucuresti);
        graph.addNode(constanta);

        Node senderNode = cluj;
        Node destinationNode = cluj;

        switch (senderCity.toLowerCase()) {
            case "cluj":
                senderNode = cluj;
                break;
            case "sibiu":
                senderNode = sibiu;
                break;
            case "brasov":
                senderNode = brasov;
                break;
            case "iasi":
                senderNode = iasi;
                break;
            case "bucuresti":
                senderNode = bucuresti;
                break;
            case "constanta":
                senderNode = constanta;
                break;
        }

        switch (destinationCity.toLowerCase()) {
            case "cluj":
                destinationNode = cluj;
                break;
            case "sibiu":
                destinationNode = sibiu;
                break;
            case "brasov":
                destinationNode = brasov;
                break;
            case "iasi":
                destinationNode = iasi;
                break;
            case "bucuresti":
                destinationNode = bucuresti;
                break;
            case "constanta":
                destinationNode = constanta;
                break;
        }

        Dijkstra.calculateShortestPathFromSource(graph, senderNode);

        List<Node> shortestRoute = destinationNode.getShortestPath();
        List<String> routeCities = new ArrayList<>();

        for (Node city : shortestRoute)
            routeCities.add(city.toString());
        routeCities.add(destinationNode.toString());
        return routeCities;
    }
}
