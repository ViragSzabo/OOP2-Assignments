package Week3.Implementation;

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

    public boolean validateAge(int userAge) throws DownloadNotAllowedException {
        if (this.containsNudity && userAge < 18) {
            throw new DownloadNotAllowedException("App contains nudity.");
        } else if (this.containsViolence && userAge < 16) {
            throw new DownloadNotAllowedException("App contains violence.");
        }
        return true;
    }
}