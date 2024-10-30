package ExamPreparation.Implementation.Remembering.System;

import ExamPreparation.Implementation.Remembering.People.Celebrity;

import java.util.ArrayList;
import java.util.List;

public class TributeManager {
    private List<Celebrity> celebrityList;

    public TributeManager() {
        celebrityList = new ArrayList<Celebrity>();
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
}