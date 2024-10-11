package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Travel.Airport;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class FlightTest {

    @Test
    public void testFlightInfo() {
        Airplane airplane = new PrivateAirplane("FG43", 1000, 10);
        Airport airport = new Airport("AMX");
        Airport airport2 = new Airport("LAX");
        Flight flight = new Flight(airplane, airport, airport2, LocalDateTime.parse("2023-09-26T12:54"));
        assertEquals("F: AMX -> LAX. Departure 2023-09-26T12:54.", flight.getFlightInfo());
    }
}