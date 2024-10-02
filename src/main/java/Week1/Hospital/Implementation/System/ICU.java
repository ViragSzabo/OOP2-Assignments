package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import Week1.Hospital.Implementation.Building.Patient;
import Week2.Implementation.Hospital_Part2.CodeBlackException;

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

    public void addDevice(MedicalDevice device) {
        devices.add(device);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    public void addPatient(Patient patient) {
        for(Bed bed : beds) {
            if(bed.getPatient().equals(patient)) {
                patients.add(patient);
            }
        }
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
        boolean admitted = false;
        for(Bed bed : beds) {
            if (!bed.isOccupied()) {
                bed.assignPatient(patient);
                patients.add(patient);
                admitted = true;
                System.out.println(patient.getName() + " is assigned to bed number " + bed.getBedNumber());
            } else {
                System.out.println(patient.getName() + " cannot be assigned.");
                throw new CodeBlackException("No available beds.");
            }
        }
        return admitted;
    }

    protected double calculateFTE() {
        double totalFTE = 0.0;

        for (MedicalDevice device : devices) {
            if (device instanceof HeartMonitor) {
                totalFTE += 0.3;
                System.out.println("Go through heart monitors: " + totalFTE);
            } else if (device instanceof BloodPressureMonitor) {
                totalFTE += 0.1;
                System.out.println("Go through blood pressure monitors: " + totalFTE);
            }
        }

        System.out.println("Go see the patient");

        for (Patient patient : patients) {
            totalFTE += (patient.isBedridden() ? 2.0 : 1.0);
            System.out.println("The patient can walk: " + patient.canWalk() + ", so total: " + totalFTE);
        }

        int totalDependencies = devices.size() + patients.size();
        if (totalDependencies > 5) {
            totalFTE += (totalDependencies - 5) * 0.2;
            System.out.println("Then the total dependencies: " + totalFTE);
        }

        System.out.println("Total: " + totalFTE);
        return totalFTE;
    }

    protected boolean isEnoughFTEForPatient() throws CodeBlackException {
        boolean isEnough = false;
        if(calculateFTE() >= 1.0) {
            System.out.println("Reached the required FTE for the patient!");
            isEnough = true;
        } else {
            throw new CodeBlackException("Not enough FTE");
        }
        return isEnough;
    }
}