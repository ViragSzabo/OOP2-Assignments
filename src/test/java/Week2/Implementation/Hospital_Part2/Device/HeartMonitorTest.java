package Week2.Implementation.Hospital_Part2.Device;

import Week2.Implementation.Hospital_Part2.System.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeartMonitorTest {
    private HeartMonitor heartMonitor;

    @Before
    public void setUp() {
        heartMonitor = new HeartMonitor("HM123", 1.0);
    }

    @Test
    public void testSetHeartRate() {
        heartMonitor.setHeartRate(75);
        assertEquals(75, heartMonitor.getHeartRate());
    }

    @Test
    public void testSetGender() {
        heartMonitor.setGender('M');
        assertEquals('M', heartMonitor.getGender());
    }

    @Test
    public void testMonitorStatusNormalForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(70);
        assertEquals(Status.NORMAL, heartMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusWarningForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(85);
        assertEquals(Status.WARNING, heartMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusCriticalForMale() {
        heartMonitor.setGender('M');
        heartMonitor.setHeartRate(59);
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());

        heartMonitor.setHeartRate(101);
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusNormalForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(75);
        assertEquals(Status.NORMAL, heartMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusWarningForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(85);
        assertEquals(Status.WARNING, heartMonitor.monitorStatus());
    }

    @Test
    public void testMonitorStatusCriticalForFemale() {
        heartMonitor.setGender('F');
        heartMonitor.setHeartRate(69);
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());

        heartMonitor.setHeartRate(111);
        assertEquals(Status.CRITICAL, heartMonitor.monitorStatus());
    }
}