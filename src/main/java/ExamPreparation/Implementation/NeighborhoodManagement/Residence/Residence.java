package ExamPreparation.Implementation.NeighborhoodManagement.Residence;

import ExamPreparation.Implementation.NeighborhoodManagement.Resident.Resident;

import java.util.ArrayList;
import java.util.List;

public abstract class Residence {
    protected String address;
    protected List<Resident> residents;

    public Residence(String address) {
        this.address = address;
        this.residents = new ArrayList<Resident>();
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Resident> getResidents() {
        return this.residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public void addResident(Resident resident) {
        this.residents.add(resident);
    }

    public void removeResident(Resident resident) {
        this.residents.remove(resident);
    }

    public abstract String getResidenceType();

}