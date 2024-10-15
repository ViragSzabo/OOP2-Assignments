package Week1.Hospital.Implementation.Staff;

import Week2.Implementation.Hospital_Part2.*;

import java.time.LocalDate;

public abstract class StaffMember {
    protected String name;
    protected LocalDate dateOfBirth;
    protected LocalDate occupationStart;
    protected FTE fteCount;

    public StaffMember(String name, LocalDate dateOfBirth, LocalDate occupationStart) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.occupationStart = occupationStart;
        this.fteCount = new FTE();
    }

    public abstract double calculateSalary();
}