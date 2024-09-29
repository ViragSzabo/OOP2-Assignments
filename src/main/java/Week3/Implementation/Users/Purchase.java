package Week3.Implementation.Users;

import Week3.Implementation.Apps.App;

public class Purchase {
    private User user;
    private App app;

    public Purchase(User user, App app) {
        this.user = user;
        this.app = app;
    }

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