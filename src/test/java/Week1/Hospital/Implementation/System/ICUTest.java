package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.BloodPressure;
import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Building.Patient;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ICUTest extends TestCase {

    private ICU icu;
    private Patient patient;
    private Bed bed;
    private BloodPressureMonitor bpMonitor;
    private HeartMonitor heartMonitor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        icu = new ICU("North Wing", 2.0);
        bed = new Bed(1);
        bpMonitor = new BloodPressureMonitor("BP123", 0.5);
        heartMonitor = new HeartMonitor("HM123", 0.7);
        patient = new Patient("John Doe", new Date(), 'M', 70, new BloodPressure(120, 80), true);
    }

    public void testGetLocation() {
        assertEquals("North Wing", icu.getLocation());
    }

    public void testSetLocation() {
        icu.setLocation("South Wing");
        assertEquals("South Wing", icu.getLocation());
    }

    public void testGetFte() {
        assertEquals(2.0, icu.getFte());
    }

    public void testSetFte() {
        icu.setFte(3.0);
        assertEquals(3.0, icu.getFte());
    }

    public void testGetBeds() {
        icu.addBed(bed);
        assertTrue(icu.getBeds().contains(bed));
    }

    public void testSetBeds() {
        List<Bed> newBeds = new ArrayList<>();
        icu.setBeds(newBeds);
        assertEquals(newBeds, icu.getBeds());
    }

    public void testAddBed() {
        icu.addBed(bed);
        assertTrue(icu.getBeds().contains(bed));
    }

    public void testGetDevices() {
        icu.getDevices().add(bpMonitor);
        icu.getDevices().add(heartMonitor);
        assertTrue(icu.getDevices().contains(bpMonitor));
        assertTrue(icu.getDevices().contains(heartMonitor));
    }

    public void testSetDevices() {
        List<MedicalDevice> newDevices = new ArrayList<>();
        icu.setDevices(newDevices);
        assertEquals(newDevices, icu.getDevices());
    }

    public void testGetPatients() {
        icu.getPatients().add(patient);
        assertTrue(icu.getPatients().contains(patient));
    }

    public void testSetPatients() {
        List<Patient> newPatients = new ArrayList<>();
        icu.setPatients(newPatients);
        assertEquals(newPatients, icu.getPatients());
    }

    public void testGetAvailableBeds() {
        icu.addBed(bed);
        assertTrue(icu.getAvailableBeds().contains(bed));
        bed.assignPatient(patient);
        assertFalse(icu.getAvailableBeds().contains(bed));
    }

    public void testGetTotalPatients() throws CodeBlackException {
        icu.addBed(bed);
        icu.admitPatient(patient);
        assertEquals(1, icu.getTotalPatients());
    }

    public void testAdmitPatient() {
        icu.addBed(bed);
        icu.setFte(1.5);
        icu.getDevices().add(bpMonitor);

        try {
            boolean result = icu.admitPatient(patient);
            assertTrue(result);
            assertTrue(bed.isOccupied());
            assertTrue(icu.getPatients().contains(patient));
        } catch (CodeBlackException e) {
            fail("Exception should not have been thrown as FTE is just enough.");
        }
    }

    public void testAdmitPatientNoAvailableBeds() {
        try {
            icu.admitPatient(patient);
            fail("Exception should have been thrown due to no available beds");
        } catch (CodeBlackException e) {
            assertEquals("No available beds.", e.getMessage());
        }
    }

    public void testAdmitPatientNotEnoughFTE() {
        icu.addBed(bed);
        icu.setFte(0.5); // Not enough FTE
        icu.getDevices().add(bpMonitor);

        try {
            icu.admitPatient(patient);
            fail("Exception should have been thrown due to not enough FTE");
        } catch (CodeBlackException e) {
            assertEquals("Not enough FTE available.", e.getMessage());
        }
    }
}