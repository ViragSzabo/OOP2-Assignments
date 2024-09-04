package Week1.Hospital.Implementation.Building;

import Week1.Hospital.Implementation.System.Status;

import java.util.Date;

public class Patient {
    private String name;
    private Date dateOfBirth;
    private char gender; // 'M' or 'F'
    private int heartRate;
    private BloodPressure bloodPressure;
    private boolean canWalk;

    public Patient(String name, Date dateOfBirth, char gender, int heartRate, BloodPressure bloodPressure, boolean canWalk) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.canWalk = canWalk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public boolean canWalk() {
        return canWalk;
    }

    public void setCanWalk(boolean canWalk) {
        this.canWalk = canWalk;
    }

    public boolean isBedridden() {
        return !canWalk;
    }

    public Status getStatus() {
        Status heartMonitorStatus = Status.NORMAL; // Default to NORMAL
        if (gender == 'M') {
            if (heartRate < 60 || heartRate > 100) {
                heartMonitorStatus = Status.CRITICAL;
            } else if (heartRate <= 75) {
                heartMonitorStatus = Status.NORMAL;
            } else if (heartRate <= 100) {
                heartMonitorStatus = Status.WARNING;
            }
        } else {
            if (heartRate < 70 || heartRate > 110) {
                heartMonitorStatus = Status.CRITICAL;
            } else if (heartRate <= 80) {
                heartMonitorStatus = Status.NORMAL;
            } else if (heartRate <= 110) {
                heartMonitorStatus = Status.WARNING;
            }
        }

        Status bpStatus = Status.NORMAL;
        if (bloodPressure.getSystolic() > 180 || bloodPressure.getDiastolic() > 110) {
            bpStatus = Status.CRITICAL;
        } else if (bloodPressure.getSystolic() > 140 || bloodPressure.getDiastolic() > 90) {
            bpStatus = Status.WARNING;
        }

        if (heartMonitorStatus == Status.CRITICAL || bpStatus == Status.CRITICAL) {
            return Status.CRITICAL;
        } else if (heartMonitorStatus == Status.WARNING || bpStatus == Status.WARNING) {
            return Status.WARNING;
        } else {
            return Status.NORMAL;
        }
    }
}
