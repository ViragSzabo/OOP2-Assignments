package ExamPreparation.Implementation.NeighborhoodManagement.Resident;

import ExamPreparation.Implementation.NeighborhoodManagement.Residence.Apartment;

import java.time.LocalDate;

public class Tenant extends Resident {
    private final Apartment apartment;

    public Tenant(String firstName, String lastName, LocalDate birthDate, Apartment apartment) {
        super(firstName, lastName, birthDate);
        this.apartment = apartment;
    }

    @Override
    public String getResidenceType() {
        return "Tenant in Apartment " + apartment.getApartmentNumber();
    }
}