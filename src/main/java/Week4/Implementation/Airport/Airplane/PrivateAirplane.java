package Week4.Implementation.Airport.Airplane;

public class PrivateAirplane extends Airplane {
    private int totalSeats;
    private int takenSeats;

    public PrivateAirplane(String code, double fuelLevel, int totalSeats) {
        super(code, fuelLevel);
        this.totalSeats = totalSeats;
        this.takenSeats = 0;
    }

    @Override
    public double calculateFuelConsumption(double distance, int takenSeats, double luggageWeight) {
        this.takenSeats = takenSeats;
        return totalSeats * 1.31 * distance + (takenSeats * 1.87) + (luggageWeight * 0.4);
    }

    @Override
    public int getEmptySeats() {
        return totalSeats - takenSeats;
    }

    public void bookSeat() {
        if (takenSeats < totalSeats) {
            takenSeats++;
        } else {
            throw new IllegalArgumentException("No empty seats available.");
        }
    }
}