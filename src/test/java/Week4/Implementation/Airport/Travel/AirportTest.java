package Week4.Implementation.Airport.Travel;

import junit.framework.TestCase;
import org.junit.Test;

public class AirportTest extends TestCase {
    private Airport jfk;
    private Airport amx;
    private Airport mex;
    private Airport lax;

    public void setUp() {
        jfk = new Airport("JFK");
        amx = new Airport("AMX");
        mex = new Airport("MEX");
        lax = new Airport("LAX");

        jfk.addDistance(amx.getCode(), 5848);
        jfk.addDistance(mex.getCode(), 3366);
        jfk.addDistance(lax.getCode(), 3975);
        amx.addDistance(mex.getCode(), 9206);
        amx.addDistance(lax.getCode(), 8956);
        mex.addDistance(lax.getCode(), 2500);
    }

    @Test
    public void testAddDistance() {
        System.out.println(jfk.getCode() + " " + jfk.getDistance());
        System.out.println(amx.getCode() + " " + amx.getDistance());
        System.out.println(mex.getCode() + " " + mex.getDistance());
        System.out.println(lax.getCode() + " " + lax.getDistance());

        assertEquals("JFK", jfk.getCode());
        assertEquals("AMX", amx.getCode());
        assertEquals("MEX", mex.getCode());
        assertEquals("LAX", lax.getCode());
    }

    @Test
    public void testGetDistance() {
        System.out.println("Size of JKF's distances: " + jfk.getDistance().size());
        System.out.println("Size of AMX's distances: " + amx.getDistance().size());
        System.out.println("Size of MEX's distances: " + mex.getDistance().size());
        System.out.println("Size of LAX's distances: " + lax.getDistance().size());

        assertEquals(3, jfk.getDistance().size());
        assertEquals(2, amx.getDistance().size());
        assertEquals(1, mex.getDistance().size());
        assertEquals(0, lax.getDistance().size());
    }

    @Test
    public void testGetCode() {
        System.out.println(jfk.getCode());
        System.out.println(amx.getCode());
        System.out.println(mex.getCode());
        System.out.println(lax.getCode());

        assertEquals("JFK", jfk.getCode());
        assertEquals("AMX", amx.getCode());
        assertEquals("MEX", mex.getCode());
        assertEquals("LAX", lax.getCode());
    }
}