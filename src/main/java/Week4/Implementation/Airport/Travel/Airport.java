package Week4.Implementation.Airport.Travel;

import java.util.HashMap;
import java.util.Map;

public class Airport {
    private final String code;
    private final Map<String, Integer> distances;

    public Airport(String code) {
        this.code = code;
        this.distances = new HashMap<>();
    }

    public void addDistance(String destinationCode, int distance) {
        this.distances.put(destinationCode, distance);
    }

    public Map<String, Integer> getDistance() {
        return this.distances;
    }

    public String getCode() { return code; }
}