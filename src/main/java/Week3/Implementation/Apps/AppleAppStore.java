package Week3.Implementation.Apps;

import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;

public class AppleAppStore extends AppStore {
    public AppleAppStore(String currency) {
        super(currency);
    }

    @Override
    public void uploadApp(App app) throws DownloadNotAllowedException {
        if (app.isContainsNudity()) {
            throw new DownloadNotAllowedException("Apple is contains Nudity");
        }
        getApps().add(app);
    }

    @Override
    public void purchase(Purchase purchase) { addPurchase(purchase); }

    public void purchaseApp(User user, App app) throws DownloadNotAllowedException {
        if (!user.canDownload(app)) {
            throw new DownloadNotAllowedException("User " + user.getName() + " is not allowed to download " + app.getName());
        }
        Purchase purchase = new Purchase(user, app);
        purchase(purchase);
    }
}