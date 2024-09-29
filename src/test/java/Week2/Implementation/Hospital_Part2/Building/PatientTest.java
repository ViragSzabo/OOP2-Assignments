package Week2.Implementation.Hospital_Part2.Building;

import Week2.Implementation.Hospital_Part2.System.Status;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class PatientTest {
    private Patient patient;
    private BloodPressure bloodPressure;

    @Before
    public void setUp() {
        bloodPressure = new BloodPressure(120, 80);
        patient = new Patient("John Doe", new Date(), 'M', 75, bloodPressure, true);
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
        Date dateOfBirth = patient.getDateOfBirth();
        assertNotNull(dateOfBirth);
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
        assertEquals(75, patient.getHeartRate());
    }

    @Test
    public void testSetHeartRate() {
        patient.setHeartRate(85);
        assertEquals(85, patient.getHeartRate());
    }

    @Test
    public void testGetBloodPressure() {
        assertEquals(bloodPressure, patient.getBloodPressure());
    }

    @Test
    public void testSetBloodPressure() {
        BloodPressure newBP = new BloodPressure(130, 90);
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
    public void testGetStatusNormal() {
        assertEquals(Status.NORMAL, patient.getStatus());
    }

    @Test
    public void testGetStatusWarning() {
        patient.setHeartRate(90);
        assertEquals(Status.WARNING, patient.getStatus());
    }

    @Test
    public void testGetStatusCritical() {
        patient.setHeartRate(59);
        assertEquals(Status.CRITICAL, patient.getStatus());

        bloodPressure.setSystolic(181); // Critical blood pressure
        assertEquals(Status.CRITICAL, patient.getStatus());
    }
}