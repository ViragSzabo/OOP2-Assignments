package ExamPreparation.Implementation.PaperCompany.EmployeeManagement.Departments;

import java.util.ArrayList;
import java.util.List;

public class RiskDepartment extends Department {
    private List<String> incidentReports;
    private double potentialRiskImpact;

    public RiskDepartment(String departmentName, double potentialRiskImpact) {
        super(departmentName);
        this.potentialRiskImpact = potentialRiskImpact;
        this.incidentReports = new ArrayList<>();
    }

    public List<String> getIncidentReports() {
        return incidentReports;
    }

    public void setIncidentReports(List<String> incidentReports) {
        this.incidentReports = incidentReports;
    }

    public double getPotentialRiskImpact() {
        return potentialRiskImpact;
    }

    public void setPotentialRiskImpact(double potentialRiskImpact) {
        this.potentialRiskImpact = potentialRiskImpact;
    }

    public void reportIncident(String incident) {
        incidentReports.add(incident);
        System.out.println("New incident report: " + incident);
    }

    @Override
    public void performDepartmentSpecificFunction() {
        System.out.println("Potential risk impact: $" + potentialRiskImpact);
        System.out.println("Incident reports: " + incidentReports);
    }
}