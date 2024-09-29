package Week3.Implementation;

import java.util.ArrayList;
import java.util.List;

public class AppStore {
    private String name;
    private String currency;
    private List<App> apps = new ArrayList<>();

    public void addApp(App app) {
        apps.add(app);
    }

    public double calculateTotalRevenue() {
        return apps.stream().mapToDouble(App::getPrice).sum();
    }
}