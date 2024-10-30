package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.Employee;

import java.util.ArrayList;
import java.util.List;

public abstract class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public double calculateTotalEarning() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calculateEarning();
        }
        return sum;
    }

    public abstract void performDepartmentSpecificFunction();
}