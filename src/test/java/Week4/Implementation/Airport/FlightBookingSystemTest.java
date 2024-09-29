package Week4.Implementation.Airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightBookingSystemTest {
    private FlightBookingSystem bookingSystem;

    @BeforeEach
    public void setUp() {
        bookingSystem = new FlightBookingSystem();
        // Add sample flights to the system
        bookingSystem.addFlight(new Flight("VMD234", "AMS", "LND", "10:00", "11:00", 75.0, 5));
        bookingSystem.addFlight(new Flight("VMD235", "AMS", "NYC", "12:00", "14:00", 150.0, 0));
        bookingSystem.addFlight(new Flight("VMD236", "LND", "NYC", "15:00", "17:00", 200.0, 2));
    }

    @Test
    public void testSearchAvailableFlights() {
        List<Flight> availableFlights = bookingSystem.searchAvailableFlights("AMS", "LND");
        assertEquals(1, availableFlights.size());
        assertEquals("VMD234", availableFlights.get(0).getFlightNumber());

        // Test with no available flights
        availableFlights = bookingSystem.searchAvailableFlights("AMS", "NYC");
        assertEquals(0, availableFlights.size());
    }

    @Test
    public void testCreateBooking_Success() {
        Passenger passenger = new Passenger("John Doe", "john@example.com", "+1234567890");
        Booking booking = bookingSystem.createBooking(bookingSystem.getFlights().get(0), passenger);

        assertNotNull(booking);
        assertEquals("open", booking.getBookingStatus());
        assertEquals(4, bookingSystem.getFlights().get(0).getAvailableSeats());
    }

    @Test
    public void testCreateBooking_NoAvailableSeats() {
        Passenger passenger = new Passenger("Jane Doe", "jane@example.com", "+0987654321");
        Booking booking = bookingSystem.createBooking(bookingSystem.getFlights().get(1), passenger);

        assertNull(booking);
    }

    @Test
    public void testCancelBooking_Success() {
        Passenger passenger = new Passenger("John Doe", "john@example.com", "+1234567890");
        Booking booking = bookingSystem.createBooking(bookingSystem.getFlights().get(0), passenger);

        assertNotNull(booking);
        bookingSystem.cancelBooking(booking);

        assertEquals(5, bookingSystem.getFlights().get(0).getAvailableSeats());
        assertEquals(0, bookingSystem.getBookings().size());
    }

    @Test
    public void testCancelBooking_NotFound() {
        Passenger passenger = new Passenger("John Doe", "john@example.com", "+1234567890");
        Booking booking = new Booking(bookingSystem.getFlights().get(0), passenger, "open");

        bookingSystem.cancelBooking(booking); // Attempting to cancel a non-existent booking
        assertEquals(5, bookingSystem.getFlights().get(0).getAvailableSeats()); // Should not change available seats
    }

    @Test
    public void testViewReservations() {
        Passenger passenger1 = new Passenger("John Doe", "john@example.com", "+1234567890");
        Passenger passenger2 = new Passenger("Jane Doe", "jane@example.com", "+0987654321");

        bookingSystem.createBooking(bookingSystem.getFlights().get(0), passenger1);
        bookingSystem.createBooking(bookingSystem.getFlights().get(2), passenger2);

        List<Booking> reservations = bookingSystem.viewReservations();
        assertEquals(2, reservations.size());
    }
}