package Week1.Hospital.Implementation.Building;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class BedTest {
    private Bed bed;
    private Patient patient;

    @Before
    public void setUp() {
        bed = new Bed(1);
        patient = new Patient("John Doe", new Date(), 'M', 80, new BloodPressure(120, 80), true);
    }

    @Test
    public void testGetBedNumber() {
        assertEquals(1, bed.getBedNumber());
    }

    @Test
    public void testSetBedNumber() {
        bed.setBedNumber(2);
        assertEquals(2, bed.getBedNumber());
    }

    @Test
    public void testGetPatient() {
        assertNull(bed.getPatient()); // No patient assigned initially
    }

    @Test
    public void testSetPatient() {
        bed.setPatient(patient);
        assertEquals(patient, bed.getPatient());
    }

    @Test
    public void testAssignPatient() {
        bed.assignPatient(patient);
        assertEquals(patient, bed.getPatient());
    }

    @Test
    public void testVacateBed() {
        bed.assignPatient(patient); // Assign patient first
        bed.vacateBed();
        assertNull(bed.getPatient()); // Bed should be vacant after vacating
    }

    @Test
    public void testIsOccupied() {
        assertFalse(bed.isOccupied()); // Bed should be empty initially
        bed.assignPatient(patient);
        assertTrue(bed.isOccupied()); // Bed should be occupied after assigning a patient
        bed.vacateBed();
        assertFalse(bed.isOccupied()); // Bed should be empty after vacating
    }
}