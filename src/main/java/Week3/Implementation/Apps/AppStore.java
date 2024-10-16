package Week3.Implementation.Apps;

import Week3.Implementation.Conditions.DownloadNotAllowedException;
import Week3.Implementation.Users.Purchase;

import java.util.ArrayList;
import java.util.List;

public abstract class AppStore {
    private String currency;
    private List<App> apps;
    protected List<Purchase> purchases;

    public AppStore(String currency) {
        this.currency = currency;
        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
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

    public void addPurchase(Purchase purchase) {
        App app = purchase.getApp();
        double getDeveloperRevenue = app.getPrice() * 0.3;
        purchases.add(purchase);
        System.out.println("App price: " + app.getPrice() +
                        " Developer's price: " + getDeveloperRevenue);
    }

    public abstract void uploadApp(App app) throws DownloadNotAllowedException;

    public abstract void purchase(Purchase purchase);

    public double calculateTotalRevenue() {
        double total = 0;
        for(Purchase purchase : purchases) {
            total += purchase.getApp().getPrice();
        }
        return total;
    }

    public double calculateRevenueForApp(App app) {
        double total = 0;
        for(Purchase purchase : purchases) {
            if(purchase.getApp().equals(app)) {
                total += app.getPrice();
            }
        }
        return total;
    }
}