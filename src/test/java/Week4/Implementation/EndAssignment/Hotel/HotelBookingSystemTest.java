package Week4.Implementation.EndAssignment.Hotel;

import Week4.Implementation.EndAssignment.Guests.Booking;
import Week4.Implementation.EndAssignment.Guests.Guest;
import Week4.Implementation.EndAssignment.Rooms.Normal;
import Week4.Implementation.EndAssignment.Rooms.Suite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class HotelBookingSystemTest {
    private HotelBookingSystem hotelBookingSystem;
    private Guest guest;
    private Booking booking;

    @BeforeEach
    public void setUp() {
        hotelBookingSystem = new HotelBookingSystem();
        hotelBookingSystem.addRoom(new Normal(20));
        hotelBookingSystem.addRoom(new Suite(30, true));
        guest = new Guest("John Doe", "123 Main St", "john@example.com", "+123456789");
        booking = new Booking(
                guest, hotelBookingSystem.getRooms().get(1),
                LocalDate.of(2024, 11, 20),
                LocalDate.of(2024, 11, 24),
                true, 2,
                1, 1);
    }

    @Test
    public void testCreateBooking() {
        hotelBookingSystem.createBooking(booking);
        assertEquals(1, hotelBookingSystem.getBookings().size());
    }

    @Test
    public void testViewBookings() {
        hotelBookingSystem.createBooking(booking);
        assertEquals(1, hotelBookingSystem.viewReservations().size());
    }
}