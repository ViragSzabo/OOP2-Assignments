package Week4.Implementation.Airport.Airplane;

import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Travel.Airport;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class PrivateAirplaneTest extends TestCase {
    Airport jfk = new Airport("JFK");
    Airport mex = new Airport("MEX");
    Airplane privatePlane = new PrivateAirplane("FVG453", 50000, 50);
    Flight flight = new Flight(privatePlane, jfk, mex, LocalDateTime.of(2024, 10, 26, 12, 54));

    public void testGetTotalSeats() {
        System.out.println(privatePlane.getCode() + " has " + privatePlane.getTotalSeats() + " seats.");
        assertEquals(50, privatePlane.getTotalSeats());
    }

    public void testGetFuelUsage() {
        System.out.println("The fuel usage for the distance: " + privatePlane.getFuelUsage(flight));
        assertEquals(65500.0, privatePlane.getFuelUsage(flight));
    }

    public void testResearveSeat() {
        System.out.println("Researve a seat is not required!");
        assertFalse(privatePlane.researveSeat(flight));
    }
}