package Week4.Implementation.Airport.Airplane;

import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Travel.Airport;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class CommercialAirplaneTest extends TestCase {
    Airport jfk = new Airport("JFK");
    Airport mex = new Airport("MEX");
    Airplane commercialPlane = new CommercialAirplane("FVG453", 50000, 25, 25);
    Flight flight = new Flight(commercialPlane, jfk, mex, LocalDateTime.of(2024, 10, 26, 12, 54));

    public void testGetTotalSeats() {
        System.out.println(commercialPlane.getCode() + " has " + commercialPlane.getTotalSeats() + " seats.");
        assertEquals(50, commercialPlane.getTotalSeats());
    }

    public void testGetFuelUsage() {
        System.out.println("The fuel usage for the distance: " + commercialPlane.getFuelUsage(flight));
        assertEquals(93250.0, commercialPlane.getFuelUsage(flight));
    }

    public void testResearveSeat() {
        System.out.println("A business or/and economy is researved: " + commercialPlane.researveSeat(flight));
        assertTrue(commercialPlane.researveSeat(flight));
    }
}