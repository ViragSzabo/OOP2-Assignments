package ExamPreparation.Implementation.PaperCompany;

import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments.SalesDepartment;
import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.Employee;
import ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Employees.SalesEmployee;

public class MichaelScottPaperCompany {
    public static void main(String[] args) {
        // Create departments
        SalesDepartment salesDepartment = new SalesDepartment("Sales", 10000); // target sales

        // Create employees
        SalesEmployee michael = new SalesEmployee("E01", "Michael Scott", 3000, salesDepartment, 0.1);
        SalesEmployee pam = new SalesEmployee("E02", "Pam Beesly", 2500, salesDepartment, 0.05);
        SalesEmployee ryan = new SalesEmployee("E03", "Ryan Howard", 2200, salesDepartment, 0.08);

        // Add employees to the company
        salesDepartment.addEmployee(michael);
        salesDepartment.addEmployee(pam);
        salesDepartment.addEmployee(ryan);


        // Record some sales
        salesDepartment.recordSale(5000);
        salesDepartment.recordSale(8000);

        // Calculate total earnings
        double totalEarnings = salesDepartment.calculateTotalEarning();
        System.out.println("Total earnings: " + totalEarnings + "  $");

        // Display details of employees and their earnings
        for (Employee employee : salesDepartment.getEmployees()) {
            double earning = employee.calculateEarning(); // Assume a method to calculate earning exists in SalesEmployee
            System.out.println(employee.getName() + "'s earnings: $" + earning);
        }
    }
}