package Week1.Hospital.Implementation.Building.Device;

import Week1.Hospital.Implementation.Patient.Patient;

import java.time.LocalDateTime;

public class BloodPressureRecord {
    private final int systolic;
    private final int diastolic;
    private final LocalDateTime timeStamp;
    private final Patient patient;
    private final BloodPressureMonitor monitor;

    public BloodPressureRecord(Patient patient, BloodPressureMonitor monitor, int systolic, int diastolic) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.timeStamp = LocalDateTime.now();
        this.patient = patient;
        this.monitor = monitor;
    }

    public String calculateStatus() {
        if (systolic > 180 || diastolic > 110) return "CRITICAL";
        if (systolic > 140 || systolic < 120 || diastolic > 90 || diastolic < 80) return "WARNING";
        return "NORMAL";
    }

    public int getSystolic() {
        return systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public LocalDateTime getTimeStamp() { return timeStamp; }

    public Patient getPatient() { return patient; }

    public BloodPressureMonitor getMonitor() { return monitor; }
}