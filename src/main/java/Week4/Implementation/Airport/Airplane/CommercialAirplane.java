package Week4.Implementation.Airport.Airplane;

public class CommercialAirplane extends Airplane {
    private int economySeats;
    private int businessSeats;
    private int economyTakenSeats;
    private int businessTakenSeats;

    public CommercialAirplane(String code, double fuelLevel, int economySeats, int businessSeats) {
        super(code, fuelLevel);
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.economyTakenSeats = 0;
        this.businessTakenSeats = 0;
    }

    @Override
    public double calculateFuelConsumption(double distance, int takenSeats, double luggageWeight) {
        return (economySeats * 1.75 + businessSeats * 1.98) * distance +
                (economyTakenSeats * 2.02) + (businessTakenSeats * 2.87) + (luggageWeight * 0.3);
    }

    @Override
    public int getEmptySeats() {
        return (economySeats - economyTakenSeats) + (businessSeats - businessTakenSeats);
    }

    public void bookEconomySeat() {
        if (economyTakenSeats < economySeats) {
            economyTakenSeats++;
        } else {
            throw new IllegalArgumentException("No empty economy seats available.");
        }
    }

    public void bookBusinessSeat() {
        if (businessTakenSeats < businessSeats) {
            businessTakenSeats++;
        } else {
            throw new IllegalArgumentException("No empty business seats available.");
        }
    }
}
