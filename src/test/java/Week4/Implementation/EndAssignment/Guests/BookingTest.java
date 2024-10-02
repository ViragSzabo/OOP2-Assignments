package Week4.Implementation.EndAssignment.Guests;

import Week4.Implementation.EndAssignment.Hotel.HotelBookingSystem;
import Week4.Implementation.EndAssignment.Rooms.Normal;
import Week4.Implementation.EndAssignment.Rooms.Room;
import Week4.Implementation.EndAssignment.Rooms.Suite;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class BookingTest extends TestCase {
    private HotelBookingSystem hotelBookingSystem;
    private Room normal;
    private Room suite;
    private Guest guest;
    private Booking booking;

    @BeforeEach
    public void setUp() {
        hotelBookingSystem = new HotelBookingSystem();
        normal = new Normal(20);
        suite = new Suite(30, true);
        hotelBookingSystem.addRoom(normal);
        hotelBookingSystem.addRoom(suite);
        guest = new Guest("John Don", "123 Main St", "john@example.com", "+123456789");
        booking = new Booking(
                guest, hotelBookingSystem.getRooms().get(1),
                LocalDate.of(2024, 11, 20),
                LocalDate.of(2024, 11, 24),
                true, 2,
                1, 1);
    }

    @Test
    public void testGetGuest() {
        assertEquals(guest, booking.getGuest());
    }

    @Test
    public void testSetGuest() {
        Guest newGuest = new Guest("John Moe", "124 Main St", "john@example.com", "+123456789");
        booking.setGuest(newGuest);
        assertEquals(newGuest.getName(), booking.getGuest().getName());
    }

    @Test
    public void testGetRoom() {
        assertEquals(suite, booking.getRoom());
    }

    @Test
    public void testSetRoom() {
        Room suite = new Suite(30, true);
        booking.setRoom(suite);
        assertEquals(suite, booking.getRoom());
    }

    @Test
    public void testGetArrivalDate() {
        assertEquals(LocalDate.of(2024, 11, 20), booking.getArrivalDate());
    }

    @Test
    public void testSetArrivalDate() {
        LocalDate newDate = LocalDate.of(2024, 12, 28);
        booking.setArrivalDate(newDate);
        assertEquals(newDate, booking.getArrivalDate());
    }

    @Test
    public void testGetDepartureDate() {
        assertEquals(LocalDate.of(2024, 11, 24), booking.getDepartureDate());
    }

    @Test
    public void testSetDepartureDate() {
        LocalDate newDate = LocalDate.of(2024, 12, 20);
        booking.setDepartureDate(newDate);
        assertEquals(newDate, booking.getDepartureDate());
    }

    @Test
    public void testIsBreakfastIncluded() {
        assertTrue(booking.isBreakfastIncluded());
    }

    @Test
    public void testSetBreakfastIncluded() {
        booking.setBreakfastIncluded(true);
        assertTrue(booking.isBreakfastIncluded());
    }

    @Test
    public void testGetChildrenCount() {
        assertEquals(2, booking.getChildrenCount());
    }

    @Test
    public void testSetChildrenCount() {
        booking.setChildrenCount(3);
        assertEquals(3, booking.getChildrenCount());
    }

    @Test
    public void testGetGuestsUnder18Count() {
        assertEquals(1, booking.getGuestsUnder18Count());
    }

    @Test
    public void testSetGuestsUnder18Count() {
        booking.setGuestsUnder18Count(1);
        assertEquals(1, booking.getGuestsUnder18Count());
    }

    @Test
    public void testGetAdultsCount() {
        assertEquals(1, booking.getAdultsCount());
    }

    @Test
    public void testSetAdultsCount() {
        booking.setAdultsCount(1);
        assertEquals(1, booking.getAdultsCount());
    }

    @Test
    public void testCalculateTotalPrice() {
        assertEquals(500.0, booking.calculateTotalPrice());
    }
}