package ExamPreparation.Implementation.NeighborhoodManagement.Building;

import ExamPreparation.Implementation.NeighborhoodManagement.Event.NeighborhoodEvent;
import ExamPreparation.Implementation.NeighborhoodManagement.Residence.ApartmentBuilding;
import ExamPreparation.Implementation.NeighborhoodManagement.Residence.House;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
    private String name;
    private List<House> houses;
    private List<ApartmentBuilding> apartmentBuildings;
    private List<NeighborhoodEvent> events;

    public Neighborhood(String name) {
        this.name = name;
        this.houses = new ArrayList<>();
        this.apartmentBuildings = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<House> getHouses() {
        return this.houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public void addHouse(House house) {
        this.houses.add(house);
    }

    public void removeHouse(House house) {
        this.houses.remove(house);
    }

    public List<ApartmentBuilding> getApartmentBuildings() {
        return this.apartmentBuildings;
    }

    public void setApartmentBuildings(List<ApartmentBuilding> apartmentBuildings) {
        this.apartmentBuildings = apartmentBuildings;
    }

    public void addApartmentBuilding(ApartmentBuilding apartmentBuilding) {
        this.apartmentBuildings.add(apartmentBuilding);
    }

    public void removeApartmentBuilding(ApartmentBuilding apartmentBuilding) {
        this.apartmentBuildings.remove(apartmentBuilding);
    }

    public List<NeighborhoodEvent> getEvents() {
        return this.events;
    }

    public void setEvents(List<NeighborhoodEvent> events) {
        this.events = events;
    }

    public void addEvent(NeighborhoodEvent event) {
        this.events.add(event);
    }

    public void removeEvent(NeighborhoodEvent event) {
        this.events.remove(event);
    }
}