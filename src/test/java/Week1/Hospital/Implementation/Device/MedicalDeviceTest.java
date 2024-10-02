package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;
import junit.framework.TestCase;

public class MedicalDeviceTest extends TestCase {
    private MedicalDevice medicalDevice;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        medicalDevice = new MedicalDevice("SN123", 1.5) {
            @Override
            public Status monitorStatus() {
                return medicalDevice.monitorStatus();
            }
        };
    }
}