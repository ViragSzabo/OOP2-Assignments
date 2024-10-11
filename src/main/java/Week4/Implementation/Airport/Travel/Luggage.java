package Week4.Implementation.Airport.Travel;

public class Luggage {
    private double weight;
    private boolean isCarryOn;

    public Luggage(double weight, boolean isCarryOn) {
        this.weight = weight;
        this.isCarryOn = isCarryOn;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isCarryOn() {
        return isCarryOn;
    }
}