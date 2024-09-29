package Week3.Implementation.Apps;

public class AppleAppStore extends AppStore {
    public AppleAppStore(String name, String currency) {
        super(name, currency);
    }

    @Override
    public void addApp(App app) throws IllegalArgumentException {
        if (app.isContainsNudity()) {
            throw new IllegalArgumentException("Apple App Store does not allow apps containing nudity.");
        } else {
            super.addApp(app);
        }
    }
}