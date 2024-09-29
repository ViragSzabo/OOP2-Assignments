package Week4.Implementation.Airport;

import java.util.ArrayList;
import java.util.List;

public class FlightBookingSystem {
    private List<Flight> flights;
    private List<Booking> bookings;

    public FlightBookingSystem() {
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Flight> searchAvailableFlights(String departure, String arrival) {
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flights) {
            // Check if the flight matches the departure and arrival locations
            if (flight.getDepartureLocation().equalsIgnoreCase(departure) &&
                    flight.getArrivalLocation().equalsIgnoreCase(arrival) &&
                    flight.getAvailableSeats() > 0) {
                availableFlights.add(flight);
            }
        }
        return availableFlights; // Return the list of available flights
    }

    public Booking createBooking(Flight flight, Passenger passenger) {
        if (flight.isAvailable(1)) { // Check if at least 1 seat is available
            flight.bookSeats(1); // Book one seat
            Booking booking = new Booking(flight, passenger, "open");
            bookings.add(booking); // Add the booking to the list
            return booking; // Return the created booking
        } else {
            System.out.println("No available seats for this flight.");
            return null; // Return null if no seats are available
        }
    }

    public void cancelBooking(Booking booking) {
        if (bookings.remove(booking)) {
            Flight flight = booking.getFlight();
            flight.setAvailableSeats(flight.getAvailableSeats() + 1); // Increase available seats
        } else {
            System.out.println("The booking is not found.");
        }
    }

    public List<Booking> viewReservations() {
        return bookings;
    }
}