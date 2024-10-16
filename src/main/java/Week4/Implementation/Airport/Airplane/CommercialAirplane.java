package Week4.Implementation.Airport.Airplane;

import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Luggage.Luggage;
import Week4.Implementation.Airport.Luggage.LuggageType;

public class CommercialAirplane extends Airplane {
    private final int economySeats;
    private final int businessSeats;
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
    public int getTotalSeats() { return economySeats + businessSeats; }

    @Override
    public double getFuelUsage(Flight flight) {
        double totalSeats = (economySeats * 1.75 + businessSeats * 1.98);
        double distance = 1000; //flight.getDepartureAirport().getDistance(flight.getArrivalAirport());

        int economyTaken = (int) (
                flight.getBookings()
                .stream()
                .filter(
                booking -> booking.getLuggages()
                        .stream()
                        .anyMatch(luggage -> luggage.getType().equals(LuggageType.CARRY_ON)))
                .count()
        );

        int businessTaken = flight.getPassengers().size() - economyTaken;
        double totalSeatsTaken = (economyTaken * 2.02) + (businessTaken * 2.87);

        double luggageWeight = flight.getBookings().stream()
                .flatMap(booking -> booking.getLuggages().stream())
                .mapToDouble(Luggage::getWeight).sum();

        totalSeatsTaken += luggageWeight * 0.3;

        return totalSeats * distance + totalSeatsTaken + luggageWeight;
    }

    @Override
    public boolean researveSeat(Flight flight) {
        if (economyTakenSeats < economySeats) {
            economyTakenSeats++;
            return true;
        } else if (businessTakenSeats < businessSeats) {
            businessTakenSeats++;
            return true;
        }
        return false;
    }
}