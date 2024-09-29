package Week2.Implementation.Hospital_Part2.Device;

import Week2.Implementation.Hospital_Part2.System.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalDeviceTest {
    private MedicalDevice medicalDevice;

    @Before
    public void setUp() {
        medicalDevice = new MedicalDevice("HM123", 1.0) {
            @Override
            public Status monitorStatus() {
                return Status.NORMAL; // Default return for the test
            }
        };
    }

    @Test
    public void testGetSerialNumber() {
        assertEquals("HM123", medicalDevice.serialNumber);
    }

    @Test
    public void testGetEnergyConsumption() {
        assertEquals(1.0, medicalDevice.energyConsumption, 0.01);
    }

    @Test
    public void testMonitorStatus() {
        assertEquals(Status.NORMAL, medicalDevice.monitorStatus());
    }

    @Test
    public void testMonitorStatusWithDifferentState() {
        medicalDevice = new MedicalDevice("HM456", 1.5) {
            @Override
            public Status monitorStatus() {
                return Status.WARNING; // Change the return for testing
            }
        };
        assertEquals(Status.WARNING, medicalDevice.monitorStatus());
    }
}