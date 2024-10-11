package Week4.Implementation.Airport.Travel;

import Week4.Implementation.Airport.Flight.Flight;

public class Passenger {
    private String name;
    private Flight flight;

    public Passenger(String name) {
        this.name = name;
    }

    public void bookFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }
}