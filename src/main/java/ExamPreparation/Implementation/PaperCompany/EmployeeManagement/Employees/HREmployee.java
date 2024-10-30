package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments.Department;

public class HREmployee extends Employee {

    public HREmployee(String employeeId, String name, double baseSalary, Department department) {
        super(employeeId, name, baseSalary, department);
    }

    @Override
    public double calculateEarning() {
        return getBaseSalary();
    }
}