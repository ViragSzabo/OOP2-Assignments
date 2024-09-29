package Week3.Implementation;

import java.util.Calendar;

public class User {
    private String name;
    private String email;
    private Calendar birthday;

    public void purchaseApp(App app, AppStore store) throws DownloadNotAllowedException {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = this.birthday;
        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        app.validateAge(age);
        store.addApp(app);
    }
}