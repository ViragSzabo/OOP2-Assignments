package Week3.Implementation.Apps;

import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;

import java.util.ArrayList;
import java.util.List;

public class AppStore {
    private String name;
    private String currency;
    private List<App> apps;
    protected List<Purchase> purchases;

    public AppStore(String name, String currency) {
        this.name = name;
        this.currency = currency;
        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addApp(App app) {
        apps.add(app);
    }

    public void purchaseApp(User user, App app) throws DownloadNotAllowedException {
        if(!app.validateAge(user.getAge())) {
            throw new DownloadNotAllowedException("User does not meet the age requirement for the app.");
        }
        purchases.add(new Purchase(user, app));
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for(Purchase purchase : purchases) {
            total += purchase.getApp().getPrice();
        }
        return total;
    }

    public double calculateRevenueForApp(String appName) {
        double appRevenue = 0;
        for(Purchase purchase : purchases) {
            if(purchase.getApp().getName().equals(appName)) {
                appRevenue += purchase.getApp().getPrice();
            }
        }
        return appRevenue;
    }
}