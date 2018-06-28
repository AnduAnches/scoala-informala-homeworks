package ro.siit.java.pds;

import java.util.HashSet;
import java.util.Set;

/**
 * Data used in the route calculation with the Dijkstra algorithm;
 */
public class Graph {

    private Set<Node> nodes = new HashSet<Node>();

    public void addNode(Node cluj) {
        nodes.add(cluj);
    }
}
