package Week4.Implementation.Airport.Travel;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Airplane.CommercialAirplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Flight.Flight;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BookingTest {
    Airplane airplane = new PrivateAirplane("FG43", 1000, 10);
    Airport airport = new Airport("AMX");
    Airport airport2 = new Airport("LAX");
    Flight flight1 = new Flight(airplane, airport,  airport2, LocalDateTime.parse("2023-09-27T12:54"));
    Flight flight2 = new Flight(airplane, airport, airport2, LocalDateTime.parse("2023-09-26T13:00"));
    Passenger passenger = new Passenger("John Doe");

    @Test
    public void testBookingTicket() {
        Airplane airplane = new CommercialAirplane("KLM123", 5000, 150, 50);

        assertEquals(200, airplane.getEmptySeats());
    }
}