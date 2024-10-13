package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.Building.Patient;

public abstract class MedicalDevice {
    protected String serialNumber;
    protected double energyConsumption;

    public MedicalDevice(String serialNumber, double energyConsumption) {
        this.serialNumber = serialNumber;
        this.energyConsumption = energyConsumption;
    }

    public abstract String monitorPatient(Patient patient);
}