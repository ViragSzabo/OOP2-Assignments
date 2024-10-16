package Week1.Hospital.Implementation.Building.Device;

import Week1.Hospital.Implementation.Patient.Patient;
import Week1.Hospital.Implementation.System.Status;

import java.time.LocalDateTime;

public class BloodPressureMonitor extends MedicalDevice {
    private final Status status;
    private final LocalDateTime timeStamp;
    private static final float BLOODPRESSUREMONITORFTE = 0.1F;

    public BloodPressureMonitor(String serialNumber, double energyConsumption) {
        super(serialNumber, energyConsumption);
        this.status = Status.NORMAL;
        this.timeStamp = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() { return timeStamp; }

    @Override
    public float calcRequiredFTE() { return BLOODPRESSUREMONITORFTE; }

    @Override
    public String monitorPatient(Patient patient) {
        return "Blood Pressure status: " + getStatus();
    }
}