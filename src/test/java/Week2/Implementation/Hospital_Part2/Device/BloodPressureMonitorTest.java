package Week2.Implementation.Hospital_Part2.Device;

import Week2.Implementation.Hospital_Part2.Building.BloodPressure;
import Week2.Implementation.Hospital_Part2.System.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloodPressureMonitorTest {
    private BloodPressureMonitor bloodPressureMonitor;
    private BloodPressure bloodPressure;

    @Before
    public void setUp() {
        bloodPressure = new BloodPressure(120, 80);
        bloodPressureMonitor = new BloodPressureMonitor("BP123", 1.5);
        bloodPressureMonitor.setBloodPressure(bloodPressure);
    }

    @Test
    public void testGetBloodPressure() {
        assertEquals(bloodPressure, bloodPressureMonitor.getBloodPressure());
    }

    @Test
    public void testSetBloodPressure() {
        BloodPressure newBP = new BloodPressure(150, 95);
        bloodPressureMonitor.setBloodPressure(newBP);
        assertEquals(newBP, bloodPressureMonitor.getBloodPressure());
    }

    @Test
    public void testMonitorStatusNormal() {
        assertEquals(Status.NORMAL, bloodPressureMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusWarning() {
        bloodPressureMonitor.setBloodPressure(new BloodPressure(145, 85)); // Warning conditions
        assertEquals(Status.WARNING, bloodPressureMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusCritical() {
        bloodPressureMonitor.setBloodPressure(new BloodPressure(181, 90)); // Critical systolic
        assertEquals(Status.CRITICAL, bloodPressureMonitor.monitorStatus());

        bloodPressureMonitor.setBloodPressure(new BloodPressure(150, 111)); // Critical diastolic
        assertEquals(Status.CRITICAL, bloodPressureMonitor.monitorStatus());
    }
}