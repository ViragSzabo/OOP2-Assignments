package Week4.Implementation.Airport.Luggage;

public class Luggage {
    private double weight;
    private LuggageType type;

    public Luggage(double weight, LuggageType type) {
        this.weight = weight;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }
    public LuggageType getType() {
        return type;
    }
    public void setWeight(double weight) { this.weight = weight; }
    public void setType(LuggageType type) { this.type = type; }
}