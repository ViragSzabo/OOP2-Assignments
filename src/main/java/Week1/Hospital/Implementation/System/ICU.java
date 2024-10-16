package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.Device.MedicalDevice;
import Week1.Hospital.Implementation.Patient.Patient;
import Week1.Hospital.Implementation.Staff.StaffMember;
import Week2.Implementation.Hospital_Part2.CodeBlackException;

import java.util.ArrayList;
import java.util.List;

public class ICU {
    private String location;
    private List<Bed> beds;
    private List<StaffMember> staffMembers;
    private List<Patient> patients;
    private List<MedicalDevice> allDevices;

    private static final float OVERHEAD_FTE_PER_UNIT = 0.2F;

    public ICU(String location) {
        this.location = location;
        this.beds = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.allDevices = new ArrayList<>();
    }

    public List<Bed> getBeds() { return beds; }

    public void addBed(Bed bed) { beds.add(bed); }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MedicalDevice> getAllDevices() { return this.allDevices; }

    public void addDevice(MedicalDevice device) { this.allDevices.add(device); }

    public void removeDevice(MedicalDevice device) { this.allDevices.remove(device); }

    public List<StaffMember> getStaffMembers() { return this.staffMembers; }

    public void addStaffMember(StaffMember staffMember) { staffMembers.add(staffMember); }

    public List<Patient> getPatients() { return patients; }

    public void addPatient(Patient patient) throws CodeBlackException {
        if(currentFTE() + patient.calcRequiredFTE() > getTotalStaffFTE()) {
            throw new CodeBlackException("ICU capacity exceeded");
        } else {
            patients.add(patient);
        }
    }

    public List<Bed> getAvailableBeds() {
        List<Bed> availableBeds = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.getIsOccupied()) {
                availableBeds.add(bed);
            }
        }
        return availableBeds;
    }

    public float currentFTE() {
        float fte = 0.0F;
        int dependencyCount = 0;

        for (MedicalDevice device : allDevices) {
            fte += device.calcRequiredFTE();
            dependencyCount++;
        }

        for (Patient patient : patients) {
            fte += patient.calcRequiredFTE();
            dependencyCount++;
        }

        if (dependencyCount > 5) {
            fte *= OVERHEAD_FTE_PER_UNIT;
        }

        return fte;
    }

    public float getTotalStaffFTE() {
        float total = 0.0F;
        for (StaffMember staffMember : staffMembers) {
            total += staffMember.getFTE();
        }
        return total;
    }
}