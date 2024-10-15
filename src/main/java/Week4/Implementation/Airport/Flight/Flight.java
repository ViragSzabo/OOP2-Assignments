package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Luggage.Luggage;
import Week4.Implementation.Airport.Travel.Airport;
import Week4.Implementation.Airport.Travel.Passenger;
import Week4.Implementation.Airport.Travel.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private FlightStatus status;
    private List<Passenger> passengers;
    private List<Booking> bookings;

    public Flight(Airplane airplane, Airport departure, Airport arrival, LocalDateTime departureTime) {
        this.airplane = airplane;
        this.departureAirport = departure;
        this.arrivalAirport = arrival;
        this.departureTime = departureTime;
        this.status = FlightStatus.AWAITING_DEPARTURE;
        this.passengers = new ArrayList<>();
        this.bookings = new ArrayList<>();

    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        this.passengers.addAll(booking.getPassenger());
    }

    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
        this.passengers.removeAll(booking.getPassenger());
    }

    public boolean checkFuel() {
        double requiredFuel = airplane.getFuelUsage(this);
        return airplane.getFuelLevel() >= requiredFuel;
    }

    public void departFlight() throws Exception {
        if (checkFuel()) {
            this.status = FlightStatus.DEPARTED;
            airplane.setFuelLevel(airplane.getFuelLevel() - airplane.getFuelUsage(this));
        } else {
            throw new Exception("Insufficient fuel for departure.");
        }
    }

    public String getFlightInfo() {
        return String.format("F: %s -> %s. Departure %s.",
                departureAirport.getCode(),
                arrivalAirport.getCode(),
                departureTime.toString().replace('T', ' '));
    }
}