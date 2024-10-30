package ExamPreparation.Implementation.Remembering.People;

import ExamPreparation.Implementation.Remembering.Works.Work;

import java.util.ArrayList;
import java.util.List;

public class Celebrity {
    private String name;
    private String profession;
    private List<Work> works;
    private List<String> tributes;

    public Celebrity(String name, String profession) {
        this.name = name;
        this.profession = profession;
        this.works = new ArrayList<>();
        this.tributes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public void addWork(Work work) {
        this.works.add(work);
    }

    public void removeWork(Work work) {
        this.works.remove(work);
    }

    public List<String> getTributes() {
        return tributes;
    }

    public void setTributes(List<String> tributes) {
        this.tributes = tributes;
    }

    public void addTribute(String tribute) {
        this.tributes.add(tribute);
    }

    public void removeTribute(String tribute) {
        this.tributes.remove(tribute);
    }

    public void displayTributes() {
        System.out.println("Tributes for " + name + ":");
        for(String tribute : tributes) {
            System.out.println(" - " + tribute);
        }
    }
}