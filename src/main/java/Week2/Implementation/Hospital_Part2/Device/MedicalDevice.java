package Week2.Implementation.Hospital_Part2.Device;

import Week2.Implementation.Hospital_Part2.System.Status;

public abstract class MedicalDevice {
    protected String serialNumber;
    protected double energyConsumption;

    public MedicalDevice(String serialNumber, double energyConsumption) {
        this.serialNumber = serialNumber;
        this.energyConsumption = energyConsumption;
    }

    public abstract Status monitorStatus();
}