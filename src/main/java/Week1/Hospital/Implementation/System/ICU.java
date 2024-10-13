package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Building.Bed;
import Week1.Hospital.Implementation.Building.Patient;
import Week1.Hospital.Implementation.Staff.StaffMember;
import Week2.Implementation.Hospital_Part2.CodeBlackException;
import Week2.Implementation.Hospital_Part2.FTECalculator;

import java.util.ArrayList;
import java.util.List;

public class ICU {
    private String location;
    private List<Bed> beds;
    private List<StaffMember> staffMembers;
    private List<Patient> patients;
    private FTECalculator fteCalculator;

    public ICU(String location) {
        this.location = location;
        this.beds = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.fteCalculator = new FTECalculator();
        this.patients = new ArrayList<>();
    }

    public FTECalculator getFteCalculator() { return fteCalculator; }

    public void setFteCalculator(FTECalculator fteCalculator) { this.fteCalculator = fteCalculator; }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Patient> getPatients() { return patients; }

    public void addPatient(Patient patient) { this.patients.add(patient); }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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

    public List<StaffMember> getStaffMember() {
        return staffMembers;
    }

    public void setStaffMember(List<StaffMember> staffMembers) { this.staffMembers = staffMembers; }

    public void addStaffMember(StaffMember staffMember) {
        staffMembers.add(staffMember);
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

    public void admitPatient(Patient patient) throws CodeBlackException {
        if(!canAdmitPatient(patient)) {
            throw new CodeBlackException("No room for new patient.");
        }
        Bed availableBed = getAvailableBeds().get(0);
        availableBed.assignPatient(patient);
        patients.add(patient);
        fteCalculator.addDependency("Patient", 1);

        if(!patient.isCanWalk()) {
            fteCalculator.addDependency("Bedridden Patient", 1);
        }
    }

    public boolean canAdmitPatient(Patient patient) {
        return !getAvailableBeds().isEmpty() && (fteCalculator.calculateTotalFTEs() < getAvailableFTEs());
    }

    public double getAvailableFTEs() {
        return 10.0;
    }
}