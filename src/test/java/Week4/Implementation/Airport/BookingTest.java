package Week4.Implementation.Airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {
    private Flight flight;
    private Passenger passenger;
    private Booking booking;

    @Before
    public void setUp() {
        // Initialize a Flight object
        flight = new Flight("FL123", "New York", "Los Angeles", "2024-09-30 10:00", "2024-09-30 13:00", 300.0, 100);

        // Initialize a Passenger object
        passenger = new Passenger("John Doe", "john@example.com", "1234567890");

        // Initialize a Booking object
        booking = new Booking(flight, passenger, "Confirmed");
    }

    @Test
    public void testGetFlight() {
        assertEquals(flight, booking.getFlight());
    }

    @Test
    public void testSetFlight() {
        Flight newFlight = new Flight("FL124", "New York", "San Francisco", "2024-09-30 14:00", "2024-09-30 17:00", 350.0, 50);
        booking.setFlight(newFlight);
        assertEquals(newFlight, booking.getFlight());
    }

    @Test
    public void testGetPassenger() {
        assertEquals(passenger, booking.getPassenger());
    }

    @Test
    public void testSetPassenger() {
        Passenger newPassenger = new Passenger("Jane Doe", "jane@example.com", "0987654321");
        booking.setPassenger(newPassenger);
        assertEquals(newPassenger, booking.getPassenger());
    }

    @Test
    public void testGetBookingStatus() {
        assertEquals("Confirmed", booking.getBookingStatus());
    }

    @Test
    public void testSetBookingStatus() {
        booking.setBookingStatus("Canceled");
        assertEquals("Canceled", booking.getBookingStatus());
    }
}