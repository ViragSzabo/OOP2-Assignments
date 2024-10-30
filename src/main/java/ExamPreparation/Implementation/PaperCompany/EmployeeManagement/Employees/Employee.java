package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments.Department;

public abstract class Employee {
    private String employeeId;
    private String name;
    private Department department;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary, Department department) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateEarning();
}
