package Week1.Hospital.Implementation.Staff;

import java.time.LocalDate;

public abstract class StaffMember {
    protected String name;
    protected LocalDate dateOfBirth;
    protected LocalDate occupationStart;

    public StaffMember(String name, LocalDate dateOfBirth, LocalDate occupationStart) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.occupationStart = occupationStart;
    }

    public abstract double calculateSalary();
}