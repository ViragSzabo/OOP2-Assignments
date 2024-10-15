package Week4.Implementation.Airport.Airplane;

import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Luggage.Luggage;

import java.util.Map;

public class PrivateAirplane extends Airplane {
    private int numberOfSeats;

    public PrivateAirplane(String code, double fuelLevel, int numberOfSeats) {
        super(code, fuelLevel);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getTotalSeats() { return this.numberOfSeats; }

    @Override
    public double getFuelUsage(Flight flight) {
        double distance = 1000; //flight.getDepartureAirport().getDistance();
        int seatsTaken = flight.getPassengers().size();
        double luggageWeight = (
                flight.getBookings().stream()
                .flatMap(booking -> booking.getLuggages().stream())
                .mapToDouble(Luggage::getWeight).sum()
        );
        return numberOfSeats * 1.31 * distance + ((seatsTaken * 1.87) + (luggageWeight * 0.4));
    }

    @Override
    public boolean researveSeat(Flight flight) {
        return false;
    }
}