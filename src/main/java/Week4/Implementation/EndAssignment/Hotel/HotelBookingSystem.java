package Week4.Implementation.EndAssignment.Hotel;

import Week4.Implementation.EndAssignment.Guests.Booking;
import Week4.Implementation.EndAssignment.Guests.Guest;
import Week4.Implementation.EndAssignment.Rooms.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {
    private List<Booking> bookings;
    private List<Room> rooms;
    private Receptionist receptionist;

    public HotelBookingSystem() {
        bookings = new ArrayList<>();
        rooms = new ArrayList<>();
        receptionist = new Receptionist();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void createBooking(Booking booking) {
        bookings.add(booking);
        booking.confirmBooking();
        receptionist.checkIn(booking.getGuest(), booking);
        receptionist.processPayment(booking);
    }

    public List<Booking> viewReservations() {
        for (Booking booking : bookings) {
            receptionist.checkIn(booking.getGuest(), booking);
        }
        return bookings;
    }
}