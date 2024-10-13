package Week3.Implementation;

import Week3.Implementation.Apps.*;
import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;

import java.time.LocalDate;

public class Example {
    public static void main(String[] args) {

        // 1. Create Users
        User user1 = new User("Alice", "alice@example.com", LocalDate.of(2005, 5, 15));
        User user2 = new User("Bob", "bob@wrong-email", LocalDate.of(2010, 2, 20));
        User user3 = new User("Charlie", "charlie@example.com", LocalDate.of(1985, 10, 5));
        User user4 = new User("Dave", "dave@example.com", LocalDate.of(2007, 8, 8));

        // 2. Create Apps
        App game1 = new App("ActionGame", 5.99, true, false);
        App game2 = new App("ArtApp", 3.49, false, true);
        App game3 = new App("CasualGame", 1.99, false, false);
        App game4 = new App("MatureGame", 7.99, true, true);

        // 3. Create App Stores
        AppStore appleStore = new AppleAppStore("USD");
        AppStore googlePlayStore = new GoogleAppStore("EUR");

        // 4. Upload Apps to App Stores
        try {
            appleStore.uploadApp(game1);
            googlePlayStore.uploadApp(game1);
            appleStore.uploadApp(game2);
            googlePlayStore.uploadApp(game2);
            appleStore.uploadApp(game3);
            googlePlayStore.uploadApp(game3);
            appleStore.uploadApp(game4);
            googlePlayStore.uploadApp(game4);
        } catch (DownloadNotAllowedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // 5. Simulate Purchases
        appleStore.purchase(new Purchase(user3, game3));
        googlePlayStore.purchase(new Purchase(user3, game4));
        googlePlayStore.purchase(new Purchase(user2, game4));

        // 6. Calculate and Display Revenue
        System.out.println("Total revenue for Apple Store: $" + appleStore.calculateTotalRevenue());
        System.out.println("Total revenue for Google Play Store: €" + googlePlayStore.calculateTotalRevenue());

        // Calculate revenue for a specific app
        System.out.println("Revenue for CasualGame in Apple Store: $" + appleStore.calculateRevenueForApp(game3));
        System.out.println("Revenue for MatureGame in Google Play Store: €" + googlePlayStore.calculateRevenueForApp(game4));
    }
}