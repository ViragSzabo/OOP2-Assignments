package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import Week1.Hospital.Implementation.Building.BloodPressure;
import Week1.Hospital.Implementation.Building.Patient;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

public class FTECalculatorTest extends TestCase {
    private List<MedicalDevice> devices;
    private List<Patient> patients;

    @Before
    public void setUp() {
        devices = new ArrayList<>();
        patients = new ArrayList<>();
    }

    @Test
    public void testCalculateFTE_NoDevicesNoPatients() {
        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(0.0, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithDevices() {
        devices.add(new HeartMonitor("HM001", 5.0));
        devices.add(new BloodPressureMonitor("BPM001", 2.0));

        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(0.3 + 0.1, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithPatients() {
        patients.add(new Patient("John Doe", new Date(), 'M', 70, new BloodPressure(120, 80), true));
        patients.add(new Patient("Jane Doe", new Date(), 'F', 90, new BloodPressure(140, 85), false));

        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(1.0 + 2.0, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithOverhead() {
        // Add 6 devices and 6 patients to exceed the overhead threshold
        for (int i = 0; i < 6; i++) {
            devices.add(new HeartMonitor("HM00" + i, 5.0));
            patients.add(new Patient("Patient " + i, new Date(), 'M', 70, new BloodPressure(120, 80), true));
        }

        double baseFTE = FTECalculator.calculateFTE(devices, patients);
        int totalDependencies = devices.size() + patients.size();
        double overhead = (totalDependencies - 5) * 0.2;
        double expectedFTE = (6 * 0.3) + (6 * 1.0) + overhead;

        assertEquals(expectedFTE, baseFTE, 0.01);
    }

    @Test
    public void testCalculateFTE_MixedDevicesAndPatients() {
        devices.add(new HeartMonitor("HM002", 5.0));
        devices.add(new BloodPressureMonitor("BPM002", 2.0));
        patients.add(new Patient("Alice", new Date(), 'F', 75, new BloodPressure(130, 85), false));
        patients.add(new Patient("Bob", new Date(), 'M', 65, new BloodPressure(150, 95), true));

        double fte = FTECalculator.calculateFTE(devices, patients);
        double expectedFTE = 0.3 + 0.1 + 1.0 + 2.0; // FTE for devices and patients
        assertEquals(expectedFTE, fte, 0.01);
    }
}