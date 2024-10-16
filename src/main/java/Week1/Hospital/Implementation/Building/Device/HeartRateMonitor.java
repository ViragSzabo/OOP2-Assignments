package Week1.Hospital.Implementation.Building.Device;

import Week1.Hospital.Implementation.Patient.Patient;
import Week1.Hospital.Implementation.System.Status;

import java.time.LocalDateTime;

public class HeartRateMonitor extends MedicalDevice {
    private final Status status;
    private final LocalDateTime timeStamp;
    private static final float HEARTRATEMONITORFTE = 0.3F;

    public HeartRateMonitor(String serialNumber, double energyConsumption) {
        super(serialNumber, energyConsumption);
        this.status = Status.NORMAL;
        this.timeStamp = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() { return timeStamp; }

    public float calcRequiredFTE() { return HEARTRATEMONITORFTE; }

    @Override
    public String monitorPatient(Patient patient) {
        return "Heart status: " + getStatus();
    }
}