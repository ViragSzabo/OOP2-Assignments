package Week1.Hospital.Implementation.Patient;

import junit.framework.TestCase;

import java.time.LocalDate;

public class PatientTest extends TestCase {
    Patient patient1 = new Patient("John", "Doe", LocalDate.of(1985, 5, 20), Gender.MALE, true);
    Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1990, 8, 15), Gender.FEMALE, false);
    Patient patient3 = new Patient("Jim", "Smith", LocalDate.of(2000, 3, 6), Gender.MALE, false);

    public void testCalcRequiredFTE() {
        assertEquals(1.0f, patient1.calcRequiredFTE());
        assertEquals(2.0f, patient2.calcRequiredFTE());
        assertEquals(2.0f, patient3.calcRequiredFTE());
    }
}