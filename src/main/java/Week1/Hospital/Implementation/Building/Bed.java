package Week1.Hospital.Implementation.Building;

import Week1.Hospital.Implementation.Device.MedicalDevice;

import java.util.ArrayList;
import java.util.List;

public class Bed {
    private int bedNumber;
    private boolean isOccupied;
    private List<MedicalDevice> devices;
    private Patient patient;

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.isOccupied = false;
        this.devices = new ArrayList<>();
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean getIsOccupied() { return this.isOccupied; }

    public List<MedicalDevice> getDevices() { return this.devices; }

    public void addDevice(MedicalDevice device) { this.devices.add(device); }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void assignPatient(Patient patient) {
        this.patient = patient;
        this.isOccupied = true;
    }

    public void releaseBed() {
        this.patient = null;
        this.isOccupied = false;
    }
}