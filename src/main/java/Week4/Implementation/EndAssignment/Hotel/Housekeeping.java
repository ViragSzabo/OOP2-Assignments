package Week4.Implementation.EndAssignment.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Housekeeping {
    private List<String> activityList;

    public Housekeeping() {
        this.activityList = new ArrayList<>();
    }

    public List<String> getActivityList() {
        return activityList;
    }

    public void setActivityList(ArrayList<String> activityList) {
        this.activityList = activityList;
    }

    public void addActivity(String activity) {
        activityList.add(activity);
    }
}