package Week1.Hospital.Implementation.Staff;

import java.time.LocalDate;

public abstract class StaffMember {
    protected String name;
    protected LocalDate dateOfBirth;
    protected LocalDate occupationStart;
    private float fte;

    public StaffMember(String name, LocalDate dateOfBirth, LocalDate occupationStart, float fte) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.occupationStart = occupationStart;
        this.fte = fte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getOccupationStart() {
        return occupationStart;
    }

    public void setOccupationStart(LocalDate occupationStart) {
        this.occupationStart = occupationStart;
    }

    public float getFTE() { return fte; }

    public void setFTE(float fte) { this.fte = fte; }

    public abstract double calculateSalary();
}