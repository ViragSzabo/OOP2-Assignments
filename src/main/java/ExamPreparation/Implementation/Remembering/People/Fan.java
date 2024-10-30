package ExamPreparation.Implementation.Remembering.People;

import ExamPreparation.Implementation.Remembering.System.Tribute;

import java.util.ArrayList;
import java.util.List;

public class Fan {
    private String fanId;
    private String name;
    private List<Tribute> tributes;
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

    public List<Tribute> getTributes() {
        return tributes;
    }

    public void setTributes(List<Tribute> tributes) {
        this.tributes = tributes;
    }

    public void addTribute(Tribute tribute) {
        this.tributes.add(tribute);
    }

    public void removeTribute(Tribute tribute) {
        this.tributes.remove(tribute);
    }

    public void likeTribute(int index) {
        if(index >= 0 && index < tributes.size()) {
            this.tributes.get(index).like();
        }
    }

    public void displayTributes() {
        System.out.println(name + "'s tributes.");
        for(Tribute tribute : tributes) {
            System.out.println("- " + tribute);
        }
    }
}