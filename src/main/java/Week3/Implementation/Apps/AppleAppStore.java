package Week3.Implementation.Apps;

import Week2.Implementation.Hospital_Part2.CodeBlackException;
import Week3.Implementation.Conditions.DownloadNotAllowedException;
import Week3.Implementation.Conditions.Validation;
import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;

public class AppleAppStore extends AppStore {
    public AppleAppStore(String currency) { super(currency); }

    @Override
    public void uploadApp(App app) throws DownloadNotAllowedException {
        if (app.isContainsNudity()) {
            throw new DownloadNotAllowedException("Apple is contains Nudity");
        }
        getApps().add(app);
    }

    @Override
    public void purchase(Purchase purchase) { addPurchase(purchase); }

    public void purchaseApp(Validation validation, User user, App app) throws DownloadNotAllowedException {
        try {
            if (!validation.checkValidationForDownload(user, app)) {
                throw new DownloadNotAllowedException(
                        "User " +
                        user.getName() +
                        " is not allowed to download " +
                        app.getName());
            }
        } catch (CodeBlackException e) { throw new RuntimeException(e); }
        Purchase purchase = new Purchase(user, app);
        purchase(purchase);
    }
}