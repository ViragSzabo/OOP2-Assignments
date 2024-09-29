package Week4.Implementation.EndAssignment;

import Week4.Implementation.EndAssignment.Guests.Guest;
import Week4.Implementation.EndAssignment.Hotel.HotelBookingSystem;
import Week4.Implementation.EndAssignment.Rooms.Normal;
import Week4.Implementation.EndAssignment.Rooms.Suite;

import java.time.LocalDate;

public class HotelExample {
    public static void main(String[] args) {
        HotelBookingSystem hotelBookingSystem = new HotelBookingSystem();

        hotelBookingSystem.addRoom(new Normal(20));
        hotelBookingSystem.addRoom(new Suite(30, true));

        Guest guest = new Guest("John Doe", "123 Main St", "john@example.com", "+123456789");

        hotelBookingSystem.createBooking(
                guest, hotelBookingSystem.getRooms().get(1),
                LocalDate.of(2024, 11, 20),
                LocalDate.of(2024, 11, 24),
                true, 2,
                1, 1);
    }
}