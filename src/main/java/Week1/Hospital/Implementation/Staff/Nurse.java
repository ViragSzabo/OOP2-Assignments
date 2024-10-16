package Week1.Hospital.Implementation.Staff;

import java.time.LocalDate;

public class Nurse  extends StaffMember {
    public Nurse(String name, LocalDate dateOfBirth, LocalDate occupationStart, float fte) {
        super(name, dateOfBirth, occupationStart, fte);
    }

    @Override
    public double calculateSalary() {
        return 3000;
    }
}