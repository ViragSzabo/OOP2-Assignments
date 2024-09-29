package Week4.Implementation.Airport;

public class Booking {
    private Flight flight;
    private Passenger passenger;
    private String bookingStatus;

    public Booking(Flight flight, Passenger passenger, String bookingStatus) {
        this.flight = flight;
        this.passenger = passenger;
        this.bookingStatus = bookingStatus;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}