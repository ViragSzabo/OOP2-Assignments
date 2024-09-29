package Week3.Implementation;

public class AppleAppStore extends AppStore {
    @Override
    public void addApp(App app) {
        if (app.isContainsNudity()) {
            System.out.println("Cannot add app with nudity.");
        } else {
            super.addApp(app);
        }
    }
}