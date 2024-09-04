package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;
import junit.framework.TestCase;

public class HeartMonitorTest extends TestCase {
    private HeartMonitor heartMonitor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        heartMonitor = new HeartMonitor("SN123", 1.5);
    }

    public void testMonitorStatusCriticalForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(55); // Below critical threshold
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());

        heartMonitor.setHeartRate(105); // Above critical threshold
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());
    }

    public void testMonitorStatusNormalForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(70); // Within normal range
        assertEquals(Status.NORMAL, heartMonitor.monitorStatus());
    }

    public void testMonitorStatusWarningForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(80); // Within warning range
        assertEquals(Status.WARNING, heartMonitor.monitorStatus());
    }

    public void testMonitorStatusCriticalForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(65); // Below critical threshold
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());

        heartMonitor.setHeartRate(115); // Above critical threshold
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());
    }

    public void testMonitorStatusNormalForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(75); // Within normal range
        assertEquals(Status.NORMAL, heartMonitor.monitorStatus());
    }

    public void testMonitorStatusWarningForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(85); // Within warning range
        assertEquals(Status.WARNING, heartMonitor.monitorStatus());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        heartMonitor = null;
    }
}