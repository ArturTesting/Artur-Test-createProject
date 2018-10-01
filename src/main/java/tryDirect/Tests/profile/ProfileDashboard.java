package tryDirect.Tests.profile;

import tryDirect.PropertyType;
import tryDirect.SetMethod;
import tryDirect.Tests.DashboardNavigation;
import tryDirect.Tests.Login;


public class ProfileDashboard {

    public static void selectMenu(String menuTitle) {
//        PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='overview']//a[contains(text(), 'Change Password')]"))
        SetMethod.Click("//div[@class='overview']//a[contains(text(), '" + menuTitle + "')]", PropertyType.XPath);
    }

    static void changePassword() {
        SetMethod.EnterText("password", "12345678", PropertyType.Name);
        SetMethod.EnterText("repeat_password", "12345678", PropertyType.Name);
        submitButtonClick("Your password has been set successfully.");

    }

    static void submitButtonClick(String notificationsText) {
        SetMethod.Click("//button[@type='submit']", PropertyType.XPath);
        DashboardNavigation dashboardNavigation = new DashboardNavigation();
        dashboardNavigation.notificationsText(notificationsText);
    }

    static void updateButtonClick(String notificationsText) {
        SetMethod.Click("//button[@class='btn-outline-primary btn btn-lg btn-primary']", PropertyType.XPath);
        DashboardNavigation dashboardNavigation = new DashboardNavigation();
        dashboardNavigation.notificationsText(notificationsText);
    }

    static void chooseSocialAccounts(String social) throws Exception {
        SetMethod.Click("//button[@title='" + social + "']", PropertyType.XPath);
    }

    public static void connectSocialAccounts(String socialAccountName) throws Exception {
        Login login = new Login();
        DashboardNavigation dashboardNavigation = new DashboardNavigation();

        login.login();
        dashboardNavigation.moveToProfile();
        chooseSocialAccounts("Github");
        login.gitLogin();
        String str = "";
    }
}
