package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Luggage.Luggage;
import Week4.Implementation.Airport.Luggage.LuggageType;
import Week4.Implementation.Airport.Travel.Airport;
import Week4.Implementation.Airport.Travel.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class FlightBookingSystemTest {
    private Airport jfk;
    private Airport mex;
    private FlightBookingSystem bookingSystem;
    private Flight flight1;
    private PrivateAirplane privatePlane;
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    public void setUp() {
        jfk = new Airport("JFK");
        mex = new Airport("MEX");

        privatePlane = new PrivateAirplane("PVT123", 10000, 5);
        flight1 = new Flight(privatePlane, jfk, mex, LocalDateTime.of(2024, 12, 25, 10, 30));

        bookingSystem = new FlightBookingSystem();
        bookingSystem.addFlight(flight1);

        passenger1 = new Passenger("Alice", "alice@example.com", "1234567890");
        passenger1.setLuggage(new Luggage(15.0, LuggageType.CARRY_ON));

        passenger2 = new Passenger("Bob", "bob@example.com", "0987654321");
        passenger2.setLuggage(new Luggage(20.0, LuggageType.CARRY_ON));
    }

    @Test
    public void searchAvailableFlights() {
        bookingSystem.searchAvailableFlights(jfk);
        System.out.println("Available flights: " +  bookingSystem.getFlights().size());
        assertEquals(1, bookingSystem.getFlights().size());
    }
}