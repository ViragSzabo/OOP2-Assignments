package Week1.Hospital.Implementation.Staff;

import java.time.LocalDate;

public class Doctor extends StaffMember {
    public Doctor(String name, LocalDate dateOfBirth, LocalDate occupationStart) {
        super(name, dateOfBirth, occupationStart);
    }

    @Override
    public double calculateSalary() {
        return 5000;
    }
}
