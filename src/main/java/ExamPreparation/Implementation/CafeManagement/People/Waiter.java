package ExamPreparation.Implementation.CafeManagement.People;

public class Waiter extends Staff {
    private static final double HOURLY_RATE = 12.0;

    public Waiter(String name) { super(name); }

    @Override
    public String getRole() { return "Waiter"; }

    @Override
    public double calculatePayment(int hoursWorked) {
        return hoursWorked * HOURLY_RATE;
    }
}