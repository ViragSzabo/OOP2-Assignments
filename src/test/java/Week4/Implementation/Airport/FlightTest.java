package Week4.Implementation.Airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {
    private Flight flight;

    @Before
    public void setUp() {
        // Initialize a Flight object before each test
        flight = new Flight("FL123", "New York", "Los Angeles", "2024-09-30 10:00", "2024-09-30 13:00", 300.0, 100);
    }

    @Test
    public void testGetFlightNumber() {
        assertEquals("FL123", flight.getFlightNumber());
    }

    @Test
    public void testSetFlightNumber() {
        flight.setFlightNumber("FL124");
        assertEquals("FL124", flight.getFlightNumber());
    }

    @Test
    public void testGetDepartureLocation() {
        assertEquals("New York", flight.getDepartureLocation());
    }

    @Test
    public void testSetDepartureLocation() {
        flight.setDepartureLocation("San Francisco");
        assertEquals("San Francisco", flight.getDepartureLocation());
    }

    @Test
    public void testGetArrivalLocation() {
        assertEquals("Los Angeles", flight.getArrivalLocation());
    }

    @Test
    public void testSetArrivalLocation() {
        flight.setArrivalLocation("Miami");
        assertEquals("Miami", flight.getArrivalLocation());
    }

    @Test
    public void testGetDepartureTime() {
        assertEquals("2024-09-30 10:00", flight.getDepartureTime());
    }

    @Test
    public void testSetDepartureTime() {
        flight.setDepartureTime("2024-09-30 11:00");
        assertEquals("2024-09-30 11:00", flight.getDepartureTime());
    }

    @Test
    public void testGetArrivalTime() {
        assertEquals("2024-09-30 13:00", flight.getArrivalTime());
    }

    @Test
    public void testSetArrivalTime() {
        flight.setArrivalTime("2024-09-30 14:00");
        assertEquals("2024-09-30 14:00", flight.getArrivalTime());
    }

    @Test
    public void testGetPrice() {
        assertEquals(300.0, flight.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice() {
        flight.setPrice(350.0);
        assertEquals(350.0, flight.getPrice(), 0.01);
    }

    @Test
    public void testGetAvailableSeats() {
        assertEquals(100, flight.getAvailableSeats());
    }

    @Test
    public void testSetAvailableSeats() {
        flight.setAvailableSeats(90);
        assertEquals(90, flight.getAvailableSeats());
    }

    @Test
    public void testIsAvailable_WhenSeatsAvailable() {
        assertTrue(flight.isAvailable(50)); // 100 available, checking for 50
    }

    @Test
    public void testIsAvailable_WhenNotEnoughSeats() {
        assertFalse(flight.isAvailable(150)); // 100 available, checking for 150
    }

    @Test
    public void testBookSeats() {
        flight.bookSeats(10); // Book 10 seats
        assertEquals(90, flight.getAvailableSeats()); // Should have 90 seats left
    }
}