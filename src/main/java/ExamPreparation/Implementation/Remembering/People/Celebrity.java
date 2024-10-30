package ExamPreparation.Implementation.Remembering.People;

import ExamPreparation.Implementation.Remembering.Works.Work;

import java.util.*;

public class Celebrity {
    private String name;
    private String profession;
    private List<String> tributes;
    private Map<Integer, List<Work>> workTimeline;

    public Celebrity(String name, String profession) {
        this.name = name;
        this.profession = profession;
        this.tributes = new ArrayList<>();
        this.workTimeline = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public Map<Integer, List<Work>> getWorkTimeline() { return workTimeline; }

    public void setWorkTimeline(Map<Integer, List<Work>> workTimeline) {
        this.workTimeline = workTimeline;
    }

    public void addWorkToTimeline(int year, Work work) {
        this.workTimeline.putIfAbsent(year, new ArrayList<>());
        this.workTimeline.get(year).add(work);
    }

    public void removeWorkTimeline(Map<Integer, List<Work>> workTimeline) {
        this.workTimeline.remove(workTimeline);
    }

    public void displayTributes() {
        System.out.println("Tributes for " + name + ":");
        for(String tribute : tributes) {
            System.out.println(" - " + tribute);
        }
    }

    public void displayWorkTimeline() {
        for(Map.Entry<Integer, List<Work>> entry : workTimeline.entrySet()) {
            System.out.println("Year: " + entry.getKey());
            for(Work work : entry.getValue()) {
                System.out.println(
                        " - " + work.getTitle() +
                        " (" + work.getType() + ")"
                );
            }
        }
    }

    public void displayTopWorks() {
        System.out.println("Top Rated Works for " + name + ":");
        this.workTimeline.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Work::calculateAverageRating).reversed())
                .forEach(work -> System.out.printf("%s (%s) - Rating: %.1f%n", work.getTitle(), work.getType(), work.calculateAverageRating()));
    }
}