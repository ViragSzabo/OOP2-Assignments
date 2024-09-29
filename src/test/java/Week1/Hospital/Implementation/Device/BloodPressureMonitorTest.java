package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;
import junit.framework.TestCase;
import Week1.Hospital.Implementation.Building.BloodPressure;

public class BloodPressureMonitorTest extends TestCase {
    private BloodPressureMonitor monitor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        monitor = new BloodPressureMonitor("SN123", 1.5);
    }

    public void testMonitorStatusCritical() {
        // Set blood pressure to values that should return CRITICAL status
        monitor.setBloodPressure(new BloodPressure(190, 120));
        assertEquals(Status.CRITICAL, monitor.monitorStatus());
    }

    public void testMonitorStatusWarning() {
        // Set blood pressure to values that should return WARNING status
        monitor.setBloodPressure(new BloodPressure(150, 85));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    public void testMonitorStatusNormal() {
        // Set blood pressure to values that should return NORMAL status
        monitor.setBloodPressure(new BloodPressure(120, 80));
        assertEquals(Status.NORMAL, monitor.monitorStatus());
    }

    public void testMonitorStatusWarningLowDiastolic() {
        // Set blood pressure with low diastolic value to test WARNING status
        monitor.setBloodPressure(new BloodPressure(130, 70));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    public void testMonitorStatusWarningLowSystolic() {
        // Set blood pressure with low systolic value to test WARNING status
        monitor.setBloodPressure(new BloodPressure(110, 85));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        monitor = null;
    }
}