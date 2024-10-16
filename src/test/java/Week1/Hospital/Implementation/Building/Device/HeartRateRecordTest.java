package Week1.Hospital.Implementation.Building.Device;

import Week1.Hospital.Implementation.Patient.Gender;
import Week1.Hospital.Implementation.Patient.Patient;
import junit.framework.TestCase;

import java.time.LocalDate;

public class HeartRateRecordTest extends TestCase {
    HeartRateMonitor hrm1 = new HeartRateMonitor("HRM-001", 50.0);

    Patient patient1 = new Patient("John", "Doe", LocalDate.of(1985, 5, 20), Gender.MALE, true);
    Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1990, 8, 15), Gender.FEMALE, false);
    Patient patient3 = new Patient("Jim", "Smith", LocalDate.of(2000, 3, 6), Gender.MALE, false);

    HeartRateRecord record1 = new HeartRateRecord(patient1, hrm1, 93);
    HeartRateRecord record2 = new HeartRateRecord(patient2, hrm1, 68);
    HeartRateRecord record3 = new HeartRateRecord(patient3, hrm1, 72);

    public void testCalculateStatus() {
        assertEquals("WARNING", record1.calculateStatus(record1.getHeartRate(), patient1.getGender()));
        assertEquals("CRITICAL", record2.calculateStatus(record2.getHeartRate(), patient2.getGender()));
        assertEquals("NORMAL", record3.calculateStatus(record3.getHeartRate(), patient3.getGender()));
    }
}