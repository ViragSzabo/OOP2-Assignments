package Week1.Hospital.Implementation.Building.Device;

import Week1.Hospital.Implementation.Patient.Gender;
import Week1.Hospital.Implementation.Patient.Patient;

import java.time.LocalDateTime;

public class HeartRateRecord {
    private final int heartRate;
    private final LocalDateTime timeStamp;
    private final Patient patient;
    private final HeartRateMonitor monitor;

    public HeartRateRecord(Patient patient, HeartRateMonitor monitor, int heartRate) {
        this.heartRate = heartRate;
        this.timeStamp = LocalDateTime.now();
        this.patient = patient;
        this.monitor = monitor;
    }

    public String calculateStatus(int heartRate, Gender gender) {
        if (gender == Gender.MALE) {
            if (heartRate < 60 || heartRate > 100) return "CRITICAL";
            if (heartRate > 75) return "WARNING";
            return "NORMAL";
        } else {
            if (heartRate < 70 || heartRate > 110) return "CRITICAL";
            if (heartRate > 80) return "WARNING";
            return "NORMAL";
        }
    }

    public int getHeartRate() {
        return heartRate;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Patient getPatient() { return patient; }

    public HeartRateMonitor getMonitor() { return monitor; }
}