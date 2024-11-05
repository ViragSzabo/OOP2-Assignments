package ExamPreparation.Implementation.NeighborhoodManagement.Residence;

import ExamPreparation.Implementation.NeighborhoodManagement.Resident.Resident;

import java.time.LocalDate;

public class HomeOwner extends Resident {
    private final House house;

    public HomeOwner(String firstName, String lastName, LocalDate birthDate, House house) {
        super(firstName, lastName, birthDate);
        this.house = house;
    }

    @Override
    public String getResidenceType() {
        return "Homeowner at " + house.getAddress();
    }
}