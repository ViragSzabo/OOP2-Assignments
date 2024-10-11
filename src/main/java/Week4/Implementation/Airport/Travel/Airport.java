package Week4.Implementation.Airport.Travel;

import java.util.HashMap;
import java.util.Map;

public class Airport {
    private String code;
    private Map<String, Integer> distances; // Distance to other airports

    public Airport(String code) {
        this.code = code;
        distances = new HashMap<>();
    }

    public void addDistance(String destinationCode, int distance) {
        distances.put(destinationCode, distance);
    }

    public int getDistance(String destinationCode) {
        return distances.getOrDefault(destinationCode, 0);
    }

    public String getCode() {
        return code;
    }
}