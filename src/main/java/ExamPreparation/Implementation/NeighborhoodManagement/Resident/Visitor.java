package ExamPreparation.Implementation.NeighborhoodManagement.Resident;

import ExamPreparation.Implementation.NeighborhoodManagement.Event.NeighborhoodEvent;

public class Visitor implements Person {
    private String firstName;
    private String lastName;
    private Resident visitedPerson;

    public Visitor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Resident getVisitedPerson() {
        return visitedPerson;
    }

    public void setVisitedPerson(Resident visitedPerson) {
        this.visitedPerson = visitedPerson;
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

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void attendEvent(NeighborhoodEvent event) {
        event.addAttendee(visitedPerson);
    }
}