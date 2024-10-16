package Week1.Hospital.Implementation.Patient;

import java.time.LocalDate;

public class Patient {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private boolean canWalk;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, boolean canWalk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.canWalk = canWalk;
    }

    public float calcRequiredFTE() { return canWalk ? 1.0f : 2.0f; }

    public void isCannotWalk(boolean canWalk) { this.canWalk = false; }

    public boolean canWalk() { return canWalk; }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}