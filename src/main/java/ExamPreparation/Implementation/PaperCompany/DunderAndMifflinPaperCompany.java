package ExamPreparation.Implementation.PaperCompany;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments.*;
import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.HREmployee;
import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.RiskEmployee;
import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.SalesEmployee;

public class DunderAndMifflinPaperCompany {
    public static void main(String[] args) {

        // Initialize departments with specific features
        SalesDepartment salesDept = new SalesDepartment("Sales", 10000); // target is $10,000
        HRDepartment hrDept = new HRDepartment("HR", 5000); // $5000 budget for benefits
        RiskDepartment riskDept = new RiskDepartment("Risk", 20000); // $20,000 potential risk impact

        // Create and add employees
        SalesEmployee michael = new SalesEmployee("E01", "Michael Scott", 2500, salesDept, 0.1);
        HREmployee toby = new HREmployee("E02", "Toby Flenderson", 2000, hrDept);
        RiskEmployee angela = new RiskEmployee("E03", "Angela Martin", 2200, riskDept);

        // Add employees to departments
        salesDept.addEmployee(michael);
        hrDept.addEmployee(toby);
        riskDept.addEmployee(angela);

        // Record some sales for Michael
        salesDept.recordSale(3000);
        salesDept.recordSale(7000);

        // Perform department-specific functions
        salesDept.performDepartmentSpecificFunction();
        hrDept.addNewHire("Jim Halpert");
        hrDept.performDepartmentSpecificFunction();
        riskDept.reportIncident("Data breach on employee information.");
        riskDept.performDepartmentSpecificFunction();
    }
}