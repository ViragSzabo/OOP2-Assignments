package Week2.Implementation.Hospital_Part2.System;

import Week2.Implementation.Hospital_Part2.Building.Bed;
import Week2.Implementation.Hospital_Part2.Building.Patient;
import Week2.Implementation.Hospital_Part2.Device.BloodPressureMonitor;
import Week2.Implementation.Hospital_Part2.Device.HeartMonitor;
import Week2.Implementation.Hospital_Part2.Device.MedicalDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ICU {
    private String location;
    private double fte;
    private final FTECalculator fteCalculator;
    private List<Bed> beds;
    private List<MedicalDevice> devices;
    private List<Patient> patients;

    public ICU(String location, double fte) {
        this.location = location;
        this.fte = fte;
        this.fteCalculator = new FTECalculator();
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
        int count = 0;
        for (Bed bed : beds) {
            if (bed.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public boolean admitPatient(Patient patient) throws CodeBlackException {
        if(!checkBedAvailability()) {
            throw new CodeBlackException("No available beds.");
        }

        double requiredFTE = FTECalculator.calculateFTE(devices, patients);
        if(fte < requiredFTE) {
            throw new CodeBlackException("Required FTE is insufficient to admit patient.");
        }

        Bed availableBed = getFirstAvailableBed();
        if(availableBed != null) {
            availableBed.assignPatient(patient);
            patients.add(patient);
            return true;
        } else {
            throw new CodeBlackException("Error in bed assignment.");
        }
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

    /**
     * Get the first available bed
     * @return a bed
     */
    private Bed getFirstAvailableBed() {
        for(Bed bed : beds) {
            if(!bed.isOccupied()) {
                return bed;
            }
        }
        return null; // should never react this point if checked properly
    }

    /**
     * Check the availability of the beds
     * @return true or false
     */
    private boolean checkBedAvailability() {
        for(Bed bed : beds) {
            if(!bed.isOccupied()) {
                return true;
            }
        }
        return false;
    }
}