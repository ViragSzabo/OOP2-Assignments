package Week1.Hospital.Implementation.Building;

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
        bloodPressure.setDiastolic(85);
        assertEquals(85, bloodPressure.getDiastolic());
    }
}