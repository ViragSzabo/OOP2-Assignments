package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;
import junit.framework.TestCase;
import Week1.Hospital.Implementation.Building.BloodPressure;

public class BloodPressureMonitorTest extends TestCase {
    private BloodPressureMonitor monitor;
    private BloodPressure bloodPressure;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bloodPressure = new BloodPressure(120, 80);
        monitor = new BloodPressureMonitor(bloodPressure,"SN123", 1.5);
    }

    public void testMonitorStatusCritical() {
        monitor.setBloodPressure(new BloodPressure(190, 120));
        assertEquals(Status.CRITICAL, monitor.monitorStatus());
    }

    public void testMonitorStatusWarning() {
        monitor.setBloodPressure(new BloodPressure(150, 85));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    public void testMonitorStatusNormal() {
        monitor.setBloodPressure(new BloodPressure(120, 80));
        assertEquals(Status.NORMAL, monitor.monitorStatus());
    }

    public void testMonitorStatusWarningLowDiastolic() {
        monitor.setBloodPressure(new BloodPressure(130, 70));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    public void testMonitorStatusWarningLowSystolic() {
        monitor.setBloodPressure(new BloodPressure(110, 85));
        assertEquals(Status.WARNING, monitor.monitorStatus());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        monitor = null;
    }
}