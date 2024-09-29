package Week2.Implementation.Hospital_Part2.Building;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloodPressureTest {
    private BloodPressure bloodPressure;

    @Before
    public void setUp() {
        bloodPressure = new BloodPressure(120, 80);
    }

    @Test
    public void testGetSystolic() {
        assertEquals(120, bloodPressure.getSystolic());
    }

    @Test
    public void testSetSystolic() {
        bloodPressure.setSystolic(130);
        assertEquals(130, bloodPressure.getSystolic());
    }

    @Test
    public void testGetDiastolic() {
        assertEquals(80, bloodPressure.getDiastolic());
    }

    @Test
    public void testSetDiastolic() {
        bloodPressure.setDiastolic(90);
        assertEquals(90, bloodPressure.getDiastolic());
    }

    public void testTestGetSystolic() {
    }

    public void testTestSetSystolic() {
    }

    public void testTestGetDiastolic() {
    }

    public void testTestSetDiastolic() {
    }
}