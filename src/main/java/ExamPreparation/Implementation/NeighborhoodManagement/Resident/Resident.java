package ExamPreparation.Implementation.NeighborhoodManagement.Resident;

import ExamPreparation.Implementation.NeighborhoodManagement.Event.NeighborhoodEvent;

import java.time.LocalDate;

public abstract class Resident implements Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Resident(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void attendEvent(NeighborhoodEvent event) {
        event.addAttendee(this);
    }

    public abstract String getResidenceType();
}