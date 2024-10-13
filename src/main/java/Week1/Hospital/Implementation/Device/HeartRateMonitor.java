package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.Building.Patient;
import Week1.Hospital.Implementation.System.Status;

public class HeartRateMonitor extends MedicalDevice {
    private Status status;

    public HeartRateMonitor(String serialNumber, double energyConsumption) {
        super(serialNumber, energyConsumption);
        this.status = Status.NORMAL;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String monitorPatient(Patient patient) {
        return "Heart status: " + getStatus();
    }
}