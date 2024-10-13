package Week3.Implementation.Users;

import Week3.Implementation.Apps.App;

import java.time.LocalDate;

public class Purchase {
    private User user;
    private App app;
    private LocalDate purchaseDate;

    public Purchase(User user, App app) {
        this.user = user;
        this.app = app;
        this.purchaseDate = LocalDate.now();
    }

    public LocalDate getPurchaseDate() { return purchaseDate; }

    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}