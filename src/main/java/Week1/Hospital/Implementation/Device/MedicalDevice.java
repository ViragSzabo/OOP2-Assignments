package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;

public abstract class MedicalDevice {
    protected String serialNumber;
    protected double energyConsumption;

    public MedicalDevice(String serialNumber, double energyConsumption) {
        this.serialNumber = serialNumber;
        this.energyConsumption = energyConsumption;
    }

    public abstract Status monitorStatus();
}