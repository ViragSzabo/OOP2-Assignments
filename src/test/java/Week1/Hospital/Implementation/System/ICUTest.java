package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Building.Device.HeartRateMonitor;
import Week1.Hospital.Implementation.Building.Device.MedicalDevice;
import Week1.Hospital.Implementation.Patient.Gender;
import Week1.Hospital.Implementation.Patient.Patient;
import Week1.Hospital.Implementation.Staff.Doctor;
import Week1.Hospital.Implementation.Staff.Nurse;
import Week1.Hospital.Implementation.Staff.StaffMember;
import Week2.Implementation.Hospital_Part2.CodeBlackException;
import junit.framework.TestCase;

import java.time.LocalDate;

public class ICUTest extends TestCase {
        ICU icu = new ICU("Zwolle Centrum Hospital");

        Bed bed1 = new Bed(1);
        Bed bed2 = new Bed(2);

        MedicalDevice hrm1 = new HeartRateMonitor("HRM-001", 50.0);
        MedicalDevice bpm1 = new BloodPressureMonitor("BPM-001", 30.0);

        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1985, 5, 20), Gender.MALE, true);
        Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1990, 8, 15), Gender.FEMALE, false);
        Patient patient3 = new Patient("Jim", "Smith", LocalDate.of(2000, 3, 6), Gender.MALE, false);

        StaffMember nurse = new Nurse("Nurse Joy", LocalDate.of(1975, 3, 25), LocalDate.of(2000, 6, 1), 2.0f);
        StaffMember doctor = new Doctor("Dr. Strange", LocalDate.of(1970, 11, 2), LocalDate.of(1995, 4, 10), 3.0f);
        StaffMember nurse2 = new Nurse("Nurse Joy", LocalDate.of(1968, 7, 17), LocalDate.of(1983, 2, 5), 2.0f);
        StaffMember doctor2 = new Doctor("Dr. Strange", LocalDate.of(1980, 10, 7), LocalDate.of(2005, 6, 1), 3.0f);

    public void testAddPatient() {
        icu.addStaffMember(nurse);
        icu.addStaffMember(doctor);
        icu.addStaffMember(nurse2);
        icu.addStaffMember(doctor2);
        icu.addBed(bed1);
        icu.addBed(bed2);
        icu.addDevice(hrm1);
        icu.addDevice(bpm1);

        bed1.addDevice(hrm1);
        bed2.addDevice(bpm1);
        bed1.assignPatient(patient1);
        bed2.assignPatient(patient2);

        try {
            icu.addPatient(patient1);
            icu.addPatient(patient2);
        } catch (CodeBlackException e) {
            throw new RuntimeException(e);
        }
    }

    public void testGetTotalStaffFTE() {
        icu.addStaffMember(nurse);
        icu.addStaffMember(doctor);
        icu.addStaffMember(nurse2);
        icu.addStaffMember(doctor2);
        assertEquals(10.0F, icu.getTotalStaffFTE());
    }

    public void testCurrentFTE() throws CodeBlackException {
        icu.addStaffMember(nurse);
        icu.addStaffMember(doctor);
        icu.addStaffMember(nurse2);
        icu.addStaffMember(doctor2);
        icu.addBed(bed1);
        icu.addBed(bed2);
        icu.addDevice(hrm1);
        icu.addDevice(bpm1);
        icu.addPatient(patient1);
        icu.addPatient(patient2);
        icu.addPatient(patient3);
        bed1.assignPatient(patient1);

        assertEquals(5.4F, icu.currentFTE());
    }

    public void testGetNoAvailableBeds() {
        icu.addStaffMember(nurse);
        icu.addStaffMember(doctor);
        icu.addStaffMember(nurse2);
        icu.addStaffMember(doctor2);
        icu.addBed(bed1);
        icu.addBed(bed2);
        icu.addDevice(hrm1);
        icu.addDevice(bpm1);
        try {
            icu.addPatient(patient1);
            icu.addPatient(patient2);
            icu.addPatient(patient3);
        } catch (CodeBlackException e) {
            throw new RuntimeException(e);
        }
        bed1.assignPatient(patient1);
        bed2.assignPatient(patient2);
        assertEquals(0, icu.getAvailableBeds().size());
    }

    public void testGetAvailableBeds() {
        icu.addStaffMember(nurse);
        icu.addStaffMember(doctor);
        icu.addStaffMember(nurse2);
        icu.addStaffMember(doctor2);
        icu.addBed(bed1);
        icu.addBed(bed2);
        icu.addDevice(hrm1);
        icu.addDevice(bpm1);
        try {
            icu.addPatient(patient1);
            icu.addPatient(patient2);
            icu.addPatient(patient3);
        } catch (CodeBlackException e) {
            throw new RuntimeException(e);
        }
        bed1.assignPatient(patient1);
        assertEquals(1, icu.getAvailableBeds().size());
    }
}