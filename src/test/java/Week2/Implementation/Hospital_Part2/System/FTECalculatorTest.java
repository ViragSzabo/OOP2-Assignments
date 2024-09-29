package Week2.Implementation.Hospital_Part2.System;

import Week2.Implementation.Hospital_Part2.Building.Patient;
import Week2.Implementation.Hospital_Part2.Device.MedicalDevice;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class FTECalculatorTest extends TestCase {
    private List<MedicalDevice> devices;
    private List<Patient> patients;

    @Before
    public void setUp() {
        devices = new ArrayList<>();
        patients = new ArrayList<>();
    }

    @Test
    public void testCalculateFTE() {
        assertEquals(0.0, FTECalculator.calculateFTE(devices, patients));
    }

    @Test
    public void testHasEnoughFTE() {
        assertFalse(devices.size() > 0);
    }

    @Test
    public void testGetCurrentAvailableFTE() {
        assertEquals(0.0, FTECalculator.calculateFTE(devices, patients));
    }
}