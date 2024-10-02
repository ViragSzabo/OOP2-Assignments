package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import Week1.Hospital.Implementation.Building.Patient;

import java.util.ArrayList;
import java.util.List;

public class ICU {
    private String location;
    private double fte;
    private List<Bed> beds;
    private List<MedicalDevice> devices;
    private List<Patient> patients;

    public ICU(String location, double fte) {
        this.location = location;
        this.fte = fte;
        this.beds = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getFte() {
        return fte;
    }

    public void setFte(double fte) {
        this.fte = fte;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }

    public List<MedicalDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<MedicalDevice> devices) {
        this.devices = devices;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Bed> getAvailableBeds() {
        List<Bed> availableBeds = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                availableBeds.add(bed);
            }
        }
        return availableBeds;
    }

    public int getTotalPatients() {
        return patients.size();
    }

    public boolean admitPatient(Patient patient) throws CodeBlackException {
        if (getAvailableBeds().isEmpty()) {
            throw new CodeBlackException("No available beds.");
        }
        double currentFTE = calculateFTE();
        System.out.println("Calculated FTE: " + currentFTE);
        if (currentFTE < requiredFTEForPatient()) {  // Change made here
            throw new CodeBlackException("Not enough FTE available.");
        }
        Bed bed = getAvailableBeds().get(0);
        bed.assignPatient(patient);
        patients.add(patient);
        return true;
    }

    private double calculateFTE() {
        double totalFTE = 0.0;
        for (MedicalDevice device : devices) {
            if (device instanceof HeartMonitor) {
                totalFTE += 0.3;
            } else if (device instanceof BloodPressureMonitor) {
                totalFTE += 0.1;
            }
        }

        for (Patient patient : patients) {
            totalFTE += patient.isBedridden() ? 2.0 : 1.0;
        }

        int totalDependencies = devices.size() + patients.size();
        if (totalDependencies > 5) {
            totalFTE += (totalDependencies - 5) * 0.2;
        }

        return totalFTE;
    }

    private double requiredFTEForPatient() {
        return 1.0;
    }
}