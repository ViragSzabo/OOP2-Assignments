package Week1.Hospital.Implementation.Building;

public class Bed {
    private int bedNumber;
    private Patient patient;

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.patient = null; // Initially, the bed is empty
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void assignPatient(Patient patient) {
        this.patient = patient;
    }

    public void vacateBed() {
        this.patient = null; // Set patient to null to vacate the bed
    }

    public boolean isOccupied() {
        return patient != null; // Bed is occupied if there is a patient
    }
}