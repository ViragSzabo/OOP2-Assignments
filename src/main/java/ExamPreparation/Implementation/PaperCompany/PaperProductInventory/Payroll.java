package ExamPreparation.Implementation.PaperCompany.PaperProductInventory;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.Employee;

public class Payroll {
    public double calculatePaycheck(Employee employee) {
        return employee.calculateEarning();
    }
}