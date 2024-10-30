package ExamPreparation.Implementation.Remembering.System;

import ExamPreparation.Implementation.Remembering.People.Celebrity;

import java.util.ArrayList;
import java.util.List;

public class TributeManager {
    private List<Tribute> tributes;
    private List<Celebrity> celebrityList;

    public TributeManager() {
        this.celebrityList = new ArrayList<Celebrity>();
        this.tributes = new ArrayList<>();
    }

    public List<Celebrity> getCelebrityList() {
        return celebrityList;
    }

    public void setCelebrityList(List<Celebrity> celebrityList) {
        this.celebrityList = celebrityList;
    }

    public void addCelebrity(Celebrity celebrity) {
        celebrityList.add(celebrity);
    }

    public void removeCelebrity(Celebrity celebrity) {
        celebrityList.remove(celebrity);
    }

    public List<Tribute> getTributes() { return tributes; }

    public void setTributes(List<Tribute> tributes) { this.tributes = tributes; }

    public void addTribute(Tribute tribute) { tributes.add(tribute); }
}