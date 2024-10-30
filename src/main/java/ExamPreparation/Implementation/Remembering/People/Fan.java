package ExamPreparation.Implementation.Remembering.People;

import java.util.ArrayList;
import java.util.List;

public class Fan {
    private String fanId;
    private String name;
    private List<String> tributes;
    private int automaticCount;

    public Fan(String name) {
        this.fanId = String.valueOf(automaticCount++);
        this.name = name;
        this.tributes = new ArrayList<>();
    }

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        System.out.println(name + "'s tributes.");
        for(String tribute : tributes) {
            System.out.println("- " + tribute);
        }
    }
}