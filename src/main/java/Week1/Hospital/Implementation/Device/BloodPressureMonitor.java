package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.Building.BloodPressure;
import Week1.Hospital.Implementation.System.Status;

public class BloodPressureMonitor extends MedicalDevice {
    private BloodPressure bloodPressure;

    public BloodPressureMonitor(String serialNumber, double energyConsumption) {
        super(serialNumber, energyConsumption);
        this.bloodPressure = bloodPressure;
    }

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public Status monitorStatus() {
        int systolic = bloodPressure.getSystolic();
        int diastolic = bloodPressure.getDiastolic();

        if (systolic > 180 || diastolic > 110) {
            return Status.CRITICAL;
        } else if (systolic > 140 || systolic < 120 || diastolic > 90 || diastolic < 80) {
            return Status.WARNING;
        } else {
            return Status.NORMAL;
        }
    }
}