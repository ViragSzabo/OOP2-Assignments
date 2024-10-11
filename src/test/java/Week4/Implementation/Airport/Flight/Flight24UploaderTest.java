package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Travel.Airport;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Flight24UploaderTest {

    @Test
    public void testGetFlightData() {
        Airplane airplane = new PrivateAirplane("FG43", 1000, 10);
        Airport airport1 = new Airport("AMX");
        Airport airport2 = new Airport("LAX");

        // Create flight instances
        Flight flight1 = new Flight(airplane, airport1, airport2, LocalDateTime.parse("2023-09-26T12:54"));
        Flight flight2 = new Flight(airplane, airport1, airport2, LocalDateTime.parse("2023-09-27T13:00"));

        // Create uploader instance with both flights
        Flight24Uploader uploader = new Flight24Uploader(Arrays.asList(flight1, flight2), "");

        // Expected flight data string
        String expectedData = "F: AMX -> LAX. Departure 2023-09-26T12:54.\n" +
                "F: AMX -> LAX. Departure 2023-09-27T13:00.\n";

        // Asserting that the actual output matches the expected output
        assertEquals(expectedData, uploader.getFlightData());
    }

    @Test
    public void testUploadFunctionality() {

        Airplane airplane = new PrivateAirplane("FG43", 1000, 10);
        Airport airport1 = new Airport("AMX");
        Airport airport2 = new Airport("LAX");
        Flight24Uploader uploader = new Flight24Uploader(Arrays.asList(new Flight(airplane, airport1, airport2, LocalDateTime.parse("2023-09-26T12:54"))), "");
    }
}