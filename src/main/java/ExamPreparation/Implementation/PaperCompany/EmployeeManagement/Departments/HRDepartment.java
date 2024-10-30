package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments;

import java.util.ArrayList;
import java.util.List;

public class HRDepartment extends Department {
    private List<String> newHires;
    private double benefitsBudget;

    public HRDepartment(String departmentName, double benefitsBudget) {
        super(departmentName);
        this.benefitsBudget = benefitsBudget;
        this.newHires = new ArrayList<>();
    }

    public List<String> getNewHires() {
        return newHires;
    }

    public void setNewHires(List<String> newHires) {
        this.newHires = newHires;
    }

    public double getBenefitsBudget() {
        return benefitsBudget;
    }

    public void setBenefitsBudget(double benefitsBudget) {
        this.benefitsBudget = benefitsBudget;
    }

    public void addNewHire(String employeeName) {
        newHires.add(employeeName);
        System.out.println("New Hire: " + employeeName);
    }

    @Override
    public void performDepartmentSpecificFunction() {
        System.out.println("Current benefits budget for " + getDepartmentName() + ": $" + benefitsBudget);
        System.out.println("New hires in the department: " + newHires);
    }
}
