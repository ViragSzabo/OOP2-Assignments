package Week2.Implementation.Hospital_Part2.System;

import Week2.Implementation.Hospital_Part2.Building.Bed;
import Week2.Implementation.Hospital_Part2.Building.BloodPressure;
import Week2.Implementation.Hospital_Part2.Building.Patient;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ICUTest {
    private ICU icu;
    private Bed bed;
    private Patient patient;
    private BloodPressure bloodPressure;

    @Before
    public void setUp() {
        icu = new ICU("ICU1", 5.0);
        bed = new Bed(1); // Specify bed number
        bloodPressure = new BloodPressure(120, 80);
        patient = new Patient("John Doe", new Date(), 'M', 75, bloodPressure, true);
        icu.addBed(bed);
    }

    @Test
    public void testAdmitPatient_Success() throws CodeBlackException {
        icu.admitPatient(patient);
        assertEquals(1, icu.getTotalPatients());
    }

    @Test
    public void testGetAvailableBeds() throws CodeBlackException {
        assertFalse(icu.getAvailableBeds().isEmpty());
    }

    @Test
    public void testGetTotalPatients() {
        assertEquals(1, icu.getTotalPatients());
    }
}