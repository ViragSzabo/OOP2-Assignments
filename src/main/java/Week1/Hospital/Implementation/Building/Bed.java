package Week1.Hospital.Implementation.Building;

public class Bed {
    private int bedNumber;
    private Patient patient;

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.patient = null;
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
        this.patient = null;
    }

    public boolean isOccupied() {
        return patient != null;
    }
}