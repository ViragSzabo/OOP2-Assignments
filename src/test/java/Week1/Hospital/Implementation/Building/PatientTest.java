package Week1.Hospital.Implementation.Building;

import Week1.Hospital.Implementation.System.Status;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class PatientTest {
    private Patient patient;
    private Patient patient1;
    private BloodPressure bloodPressure;

    @Before
    public void setUp() {
        // Initialize BloodPressure object
        bloodPressure = new BloodPressure(120, 80);
        // Initialize Patient object
        patient = new Patient("John Doe", new Date(), 'M', 80, bloodPressure, true);
        patient1 = new Patient("Mary Moe", new Date(), 'F', 75, bloodPressure, true);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", patient.getName());
    }

    @Test
    public void testSetName() {
        patient.setName("Jane Doe");
        assertEquals("Jane Doe", patient.getName());
    }

    @Test
    public void testGetDateOfBirth() {
        // You may need to check the exact date
        assertNotNull(patient.getDateOfBirth());
    }

    @Test
    public void testSetDateOfBirth() {
        Date newDate = new Date();
        patient.setDateOfBirth(newDate);
        assertEquals(newDate, patient.getDateOfBirth());
    }

    @Test
    public void testGetGender() {
        assertEquals('M', patient.getGender());
    }

    @Test
    public void testSetGender() {
        patient.setGender('F');
        assertEquals('F', patient.getGender());
    }

    @Test
    public void testGetHeartRate() {
        assertEquals(80, patient.getHeartRate());
    }

    @Test
    public void testSetHeartRate() {
        patient.setHeartRate(90);
        assertEquals(90, patient.getHeartRate());
    }

    @Test
    public void testGetBloodPressure() {
        assertEquals(bloodPressure, patient.getBloodPressure());
    }

    @Test
    public void testSetBloodPressure() {
        BloodPressure newBP = new BloodPressure(130, 85);
        patient.setBloodPressure(newBP);
        assertEquals(newBP, patient.getBloodPressure());
    }

    @Test
    public void testCanWalk() {
        assertTrue(patient.canWalk());
    }

    @Test
    public void testSetCanWalk() {
        patient.setCanWalk(false);
        assertFalse(patient.canWalk());
    }

    @Test
    public void testIsBedridden() {
        assertFalse(patient.isBedridden());
        patient.setCanWalk(false);
        assertTrue(patient.isBedridden());
    }

    @Test
    public void testGetStatus() {
        // For NORMAL status
        assertEquals(Status.NORMAL, patient1.getStatus());

        // For WARNING status
        patient.setHeartRate(76);
        assertEquals(Status.WARNING, patient.getStatus());

        // For CRITICAL status
        patient.setHeartRate(101);
        assertEquals(Status.CRITICAL, patient.getStatus());

        // Test with Blood Pressure
        patient.setHeartRate(80);
        patient.getBloodPressure().setSystolic(181);
        assertEquals(Status.CRITICAL, patient.getStatus());
    }
}