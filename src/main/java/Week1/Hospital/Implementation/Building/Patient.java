package Week1.Hospital.Implementation.Building;

import Week1.Hospital.Implementation.Device.BloodPressureRecord;
import Week1.Hospital.Implementation.Device.HeartRateRecord;

import java.time.LocalDate;

public class Patient {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private boolean canWalk;
    private HeartRateRecord heartRate;
    private BloodPressureRecord bloodPressure;

    public Patient(String name, LocalDate dateOfBirth, Gender gender, boolean canWalk) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.canWalk = canWalk;
    }

    public HeartRateRecord getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(HeartRateRecord heartRate) {
        this.heartRate = heartRate;
    }

    public BloodPressureRecord getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressureRecord bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setCanWalk(boolean canWalk) {
        this.canWalk = canWalk;
    }

    public boolean isCanWalk() {
        return canWalk;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}