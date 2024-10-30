package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments;

public class SalesDepartment extends Department {
    private double monthlyTarget;
    private double monthlyTotalSales;

    public SalesDepartment(String departmentName, double monthlyTarget) {
        super(departmentName);
        this.monthlyTarget = monthlyTarget;
        this.monthlyTotalSales = 0;
    }

    public double getMonthlyTarget() {
        return monthlyTarget;
    }

    public void setMonthlyTarget(double monthlyTarget) {
        this.monthlyTarget = monthlyTarget;
    }

    public double getMonthlyTotalSales() {
        return monthlyTotalSales;
    }

    public void setMonthlyTotalSales(double monthlyTotalSales) {
        this.monthlyTotalSales = monthlyTotalSales;
    }

    public void recordSale(double saleAmount) {
        this.monthlyTotalSales += saleAmount;
    }

    public boolean isTargetMet() {
        return monthlyTotalSales >= monthlyTarget;
    }

    @Override
    public void performDepartmentSpecificFunction() {
        System.out.println("Total sales this month: $" + monthlyTotalSales);
        if (isTargetMet()) {
            System.out.println("Sales target met for " + getDepartmentName());
        } else {
            System.out.println("Sales target not met for " + getDepartmentName());
        }
    }
}