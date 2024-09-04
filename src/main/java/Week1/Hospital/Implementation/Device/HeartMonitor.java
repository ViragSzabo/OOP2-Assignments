package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.System.Status;

public class HeartMonitor extends MedicalDevice {
    private int heartRate;
    private char gender; // 'M' or 'F'

    public HeartMonitor(String serialNumber, double energyConsumption) {
        super(serialNumber, energyConsumption);
        this.heartRate = heartRate;
        this.gender = gender;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public Status monitorStatus() {
        if(gender == 'M') {
            if(heartRate < 60 || heartRate > 100) {
                return Status.CRITICAL;
            } else if(heartRate <= 75) {
                return Status.NORMAL;
            } else {
                return Status.WARNING;
            }
        } else {
            if(heartRate < 70 || heartRate > 110) {
                return Status.CRITICAL;
            } else if(heartRate <= 80) {
                return Status.NORMAL;
            } else {
                return Status.WARNING;
            }
        }
    }
}