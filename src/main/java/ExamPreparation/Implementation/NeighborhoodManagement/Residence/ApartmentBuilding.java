package ExamPreparation.Implementation.NeighborhoodManagement.Residence;

import java.util.ArrayList;
import java.util.List;

public class ApartmentBuilding extends Residence {
    private List<Apartment> apartments;
    private List<FacilityType> facilities;

    public ApartmentBuilding(String address) {
        super(address);
        this.apartments = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<FacilityType> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityType> facilities) {
        this.facilities = facilities;
    }

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
    }

    public void removeApartment(Apartment apartment) {
        this.apartments.remove(apartment);
    }

    public void addFacilityType(FacilityType facilityType) {
        this.facilities.add(facilityType);
    }

    public void removeFacilityType(FacilityType facilityType) {
        this.facilities.remove(facilityType);
    }

    @Override
    public String getResidenceType() {
        return "Apartment Building";
    }
}