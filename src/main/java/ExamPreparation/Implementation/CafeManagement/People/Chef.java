package ExamPreparation.Implementation.CafeManagement.People;

public class Chef extends Staff {
    private static final double HOURLY_RATE = 20.0;

    public Chef(String name) { super(name); }

    @Override
    public String getRole() { return "Chef"; }

    @Override
    public double calculatePayment(int hoursWorked) {
        return hoursWorked * HOURLY_RATE;
    }
}