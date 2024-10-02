package Week2.Implementation.Hospital_Part2;

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
    private HeartMonitor heartMonitor;
    private BloodPressureMonitor monitor;
    private BloodPressure bloodPressure;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    private Patient patient4;

    @Before
    public void setUp() {
        devices = new ArrayList<>();
        patients = new ArrayList<>();
        bloodPressure = new BloodPressure(120, 80);
        heartMonitor = new HeartMonitor(75, 'F',"SN123", 1.5);
        monitor = new BloodPressureMonitor(bloodPressure,"SN123", 1.5);
        patient1 = new Patient("John Doe", new Date(), 'M', 70, new BloodPressure(120, 80), true);
        patient2 = new Patient("Jane Doe", new Date(), 'F', 90, new BloodPressure(140, 85), false);
        patient3 = new Patient("Alice", new Date(), 'F', 75, new BloodPressure(130, 85), false);
        patient4 = new Patient("Bob", new Date(), 'M', 65, new BloodPressure(150, 95), true);
    }

    @Test
    public void testCalculateFTE_NoDevicesNoPatients() {
        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(0.0, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithDevices() {
        devices.add(heartMonitor);
        devices.add(monitor);

        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(0.3 + 0.1, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithPatients() {
        patients.add(patient1);
        patients.add(patient2);

        double fte = FTECalculator.calculateFTE(devices, patients);
        assertEquals(1.0 + 2.0, fte, 0.01);
    }

    @Test
    public void testCalculateFTE_WithOverhead() {
        for (int i = 0; i < 6; i++) {
            devices.add(heartMonitor);
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
        devices.add(heartMonitor);
        devices.add(monitor);
        patients.add(patient3);
        patients.add(patient4);

        double fte = FTECalculator.calculateFTE(devices, patients);
        double expectedFTE = 0.3 + 0.1 + 1.0 + 2.0;
        assertEquals(expectedFTE, fte, 0.01);
    }
}