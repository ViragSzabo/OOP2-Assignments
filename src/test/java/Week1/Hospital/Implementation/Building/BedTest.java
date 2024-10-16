package Week1.Hospital.Implementation.Building;

import Week1.Hospital.Implementation.Patient.Gender;
import Week1.Hospital.Implementation.Patient.Patient;
import junit.framework.TestCase;

import java.time.LocalDate;

public class BedTest extends TestCase {
    Bed bed = new Bed(450);
    Patient patient = new Patient("Olivia", "Green", LocalDate.of(1987, 12, 25), Gender.FEMALE, true);

    public void testAssignPatient() {
        bed.assignPatient(patient);
        assertEquals(patient, bed.getPatient());
    }

    public void testReleaseBed() {
        bed.assignPatient(patient);
        bed.releaseBed();
        assertNull(bed.getPatient());
    }
}