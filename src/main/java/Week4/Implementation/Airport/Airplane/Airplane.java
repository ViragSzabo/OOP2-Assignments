package Week4.Implementation.Airport.Airplane;

public abstract class Airplane {
    protected String code;
    protected double currentFuelLevel;

    public Airplane(String code, double fuelLevel) {
        this.code = code;
        this.currentFuelLevel = fuelLevel;
    }

    public abstract double calculateFuelConsumption(double distance, int takenSeats, double luggageWeight);
    public abstract int getEmptySeats();

    public String getCode() {
        return code;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }
}