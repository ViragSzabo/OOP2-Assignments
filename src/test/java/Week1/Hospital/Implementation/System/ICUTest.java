package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.Gender;
import Week1.Hospital.Implementation.Building.Patient;
import Week2.Implementation.Hospital_Part2.CodeBlackException;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ICUTest {

    private ICU icu;
    Patient patient;
    Bed bed;

    @Before
    public void setUp() throws Exception {
        icu = new ICU("Main");
        patient = new Patient("John Doe", LocalDate.of(1990, 1, 1), Gender.MALE, true);
        bed = new Bed(1);
    }

    @Test
    public void testAdmitPatient_NoAvailableBeds_ShouldThrowCodeBlackException() throws CodeBlackException {
        Patient patient = new Patient("John Doe", LocalDate.of(1990, 1, 1), Gender.MALE, true);

        try {
            icu.admitPatient(patient);
        } catch (CodeBlackException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(0, icu.getPatients().size());
    }

    @Test
    public void testAdmitPatient_WithAvailableBed_ShouldAdmitPatient() throws CodeBlackException {
        icu.addBed(bed);

        try {
            icu.admitPatient(patient);
            System.out.println(patient.getName() +  " can walk: " + patient.isCanWalk());
        } catch (CodeBlackException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(1, icu.getPatients().size());
        assertEquals(patient, icu.getPatients().get(0));
        assertTrue(bed.getIsOccupied());
    }
}