package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Airplane.CommercialAirplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Travel.Airport;
import Week4.Implementation.Airport.Travel.Passenger;
import Week4.Implementation.Airport.Travel.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightBookingSystem {
    private final List<Flight> flights;
    private final List<Booking> bookings;

    public FlightBookingSystem() {
        this.flights = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public List<Flight> getFlights() { return flights; }
    public List<Booking> getBookings() {  return bookings; }

    public List<Flight> searchAvailableFlights(Airport departure) {
        return flights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(departure)
                        && flight.getStatus() == FlightStatus.AWAITING_DEPARTURE)
                .collect(Collectors.toList());
    }

    public Booking createBooking(Flight flight, List<Passenger> passengers) throws Exception {
        if (flight.getStatus() != FlightStatus.AWAITING_DEPARTURE) {
            throw new Exception("Flight is not available for booking.");
        }
        Booking booking = new Booking(flight);
        for (Passenger passenger : passengers) {
            Airplane airplane = flight.getAirplane();
            if (airplane instanceof CommercialAirplane) {
                CommercialAirplane commercial = (CommercialAirplane) airplane;
                boolean seatReserved = commercial.researveSeat(flight);
                if (!seatReserved) {
                    throw new Exception("No available seats on the flight.");
                }
            } else if (airplane instanceof PrivateAirplane) {
                PrivateAirplane privatePlane = (PrivateAirplane) airplane;
                if (flight.getPassengers().size() >= privatePlane.getTotalSeats()) {
                    throw new Exception("No available seats on the flight.");
                }
            }
            booking.addPassenger(passenger);
        }
        this.bookings.add(booking);
        flight.addBooking(booking);
        return booking;
    }

    public void cancelBooking(Booking booking) throws Exception {
        try {
            booking.cancelBooking();
            this.bookings.remove(booking);
            booking.getFlight().removeBooking(booking);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Booking> viewReservations(Passenger user) {
        return bookings.stream()
                .filter(booking -> booking.getPassenger().stream()
                        .anyMatch(passenger ->
                                passenger.getName()
                                        .equals(user.getName())))
                .collect(Collectors.toList());
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
    }
}
