package Week3.Implementation;

import Week3.Implementation.Apps.*;
import Week3.Implementation.Users.User;

import java.time.LocalDate;

public class Example {
    public static void main(String[] args) {
        try {
            // Create instances of app stores
            AppStore appleStore = new AppleAppStore("Apple Store", "EUR");
            AppStore googleStore = new GoogleAppStore("Google Play", "USD");

            // Create apps
            App app1 = new App("Super Fighter", 5.99, true, false);
            App app2 = new App("Romance Story", 3.99, false, true);
            App app3 = new App("Puzzle Game", 1.99, false, false);

            // Add apps to stores
            appleStore.addApp(app1);
            appleStore.addApp(app3);
            googleStore.addApp(app2);
            googleStore.addApp(app3);

            // Create users
            User user1 = new User("Alice", "alice@example.com", LocalDate.of(2001, 1, 1));
            User user2 = new User("Bob", "bob@example.com", LocalDate.of(2000, 11, 14));

            // Attempt to purchase apps
            appleStore.purchaseApp(user1, app1);
            googleStore.purchaseApp(user1, app3);
            googleStore.purchaseApp(user2, app2);

            appleStore.purchaseApp(user2, app2);

        } catch (DownloadNotAllowedException e) {
            System.out.println(e.getMessage());
        }
    }
}