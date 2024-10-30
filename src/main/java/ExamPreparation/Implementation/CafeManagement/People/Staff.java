package ExamPreparation.Implementation.CafeManagement.People;

public abstract class Staff {
    private String staffId;
    private String name;

    public Staff(String name) {
        this.staffId = String.valueOf(1);
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getRole();
    public abstract double calculatePayment(int hoursWorked);
}