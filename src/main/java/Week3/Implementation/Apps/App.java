package Week3.Implementation.Apps;

public class App {
    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price, boolean violence, boolean nudity) {
        this.name = name;
        this.price = price;
        this.containsViolence = violence;
        this.containsNudity = nudity;
    }

    public void registerApp() {
        new App(this.name, this.price, this.containsViolence, this.containsNudity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isContainsViolence() {
        return containsViolence;
    }

    public void setContainsViolence(boolean containsViolence) {
        this.containsViolence = containsViolence;
    }

    public boolean isContainsNudity() {
        return containsNudity;
    }

    public void setContainsNudity(boolean containsNudity) {
        this.containsNudity = containsNudity;
    }
}