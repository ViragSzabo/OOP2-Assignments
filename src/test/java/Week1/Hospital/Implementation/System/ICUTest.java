package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.BloodPressure;
import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Building.Patient;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import Week2.Implementation.Hospital_Part2.CodeBlackException;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ICUTest extends TestCase {

    private ICU icu;
    private Patient patient;
    private Patient newPatient;
    private Bed bed;
    private Bed emptyBed;
    private BloodPressure bloodPressure;
    private BloodPressureMonitor monitor;
    private HeartMonitor heartMonitor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        icu = new ICU("North Wing", 2.0);
        bed = new Bed(1);
        emptyBed = new Bed(2);
        bloodPressure = new BloodPressure(120, 80);
        heartMonitor = new HeartMonitor(75, 'F',"SN123", 1.5);
        monitor = new BloodPressureMonitor(bloodPressure,"SN123", 1.5);
        patient = new Patient("John Doe", new Date(), 'M', 70, new BloodPressure(120, 80), true);
        newPatient = new Patient("Jane Doe", new Date(), 'F', 70, new BloodPressure(120, 80), false);
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
        icu.getDevices().add(monitor);
        icu.getDevices().add(heartMonitor);
        assertTrue(icu.getDevices().contains(monitor));
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

    public void testGetTotalPatients() {
        assertEquals(0, icu.getTotalPatients());
    }

    public void testAdmitPatient() {
        try {
            icu.addBed(bed);
            assertTrue(icu.admitPatient(patient));
            assertTrue(bed.isOccupied());
            assertTrue(icu.getPatients().contains(patient));
        } catch (CodeBlackException e) {
            fail("Exception should not have been thrown as FTE is just enough.");
        }
    }

    public void testAdmitPatientNoAvailableBeds() {
        try {
            icu.addBed(bed);
            icu.admitPatient(patient);
            icu.admitPatient(newPatient);
            fail("Exception should have been thrown due to no available beds");
        } catch (CodeBlackException e) {
            assertEquals("No available beds.", e.getMessage());
        }
    }

    public void testAdmitPatientNotEnoughFTE() throws CodeBlackException {
        icu.addDevice(heartMonitor);
        try {
            icu.admitPatient(newPatient);
            assertFalse(icu.isEnoughFTEForPatient());
            fail("Exception should have been thrown due to not enough FTE");
        } catch (CodeBlackException e) {
            assertTrue(e.getMessage().contains("Not enough FTE"));
        }
    }

    public void testCaluclateFTE() {
        icu.addDevice(heartMonitor);
        icu.addDevice(monitor);
        icu.addBed(emptyBed);
        try {
            icu.admitPatient(newPatient);
        } catch (CodeBlackException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2.4, icu.calculateFTE());
    }
}