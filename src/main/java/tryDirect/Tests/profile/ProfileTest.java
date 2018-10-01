package tryDirect.Tests.profile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import tryDirect.Connect;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;
import tryDirect.Tests.DashboardInstalation;
import tryDirect.Tests.DashboardNavigation;
import tryDirect.Tests.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileTest {

    private Login login = new Login();
    private DashboardNavigation dashboardNavigation = new DashboardNavigation();
    private DashboardInstalation dashboardInstalation = new DashboardInstalation();

    @Test
    public void changeAccountInformation() throws IOException {
        login.login();
        dashboardNavigation.moveToProfile();

        SetMethod.EnterText("first_name", "test FirstName", PropertyType.Name);
        SetMethod.EnterText("last_name", "test LastName", PropertyType.Name);
        SetMethod.EnterText("website", "testWebsite.com", PropertyType.Name);
        SetMethod.EnterText("phone", "45645645645", PropertyType.Name);
        dashboardInstalation.chooseCountryAI();

        ProfileDashboard.updateButtonClick("Profile changes saved"); // кликает и проверяет Нотификацию

        CleanUp();
    }

    @Test
    public void changePaswordTest() throws IOException {
        login.login();
        dashboardNavigation.moveToProfile();

        ProfileDashboard.selectMenu("Change Password");
        ProfileDashboard.changePassword(); // меняет и проверяет если появилась notificationsText

        CleanUp();
    }

    @Test
    public void fillBilling() throws IOException {
        login.login();
        dashboardNavigation.moveToProfile();
        ProfileDashboard.selectMenu("Billing address");
        SetMethod.EnterText("billing_first_name","Antoni", PropertyType.Name);
        SetMethod.EnterText("billing_last_name","Antoni", PropertyType.Name);
        SetMethod.EnterText("billing_postcode","1234", PropertyType.Name);
        SetMethod.EnterText("billing_address_1","TestAdress", PropertyType.Name);
        SetMethod.EnterText("billing_address_2","TestAdress2", PropertyType.Name);
        SetMethod.EnterText("billing_city","Chisinau", PropertyType.Name);
        dashboardInstalation.chooseCountryAI();
        SetMethod.EnterText("billing_country_area","AfricaTest", PropertyType.Name);
        ProfileDashboard.updateButtonClick("Profile changes saved");
    }
    @Test  // Удаляет все поля  .
    public void clearBilling() throws IOException, InterruptedException {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        login.login();
        dashboardNavigation.moveToProfile();
        ProfileDashboard.selectMenu("Billing address");
        List<WebElement> allField = PropertiesCollection.GetDrivers().findElements(By.xpath("//input"));

        for (int i = 0; i <allField.size() ; i++) {
//            Thread.sleep(1000);
            try {
                if (!(allField.get(i).getAttribute("value").isEmpty() )) allField.get(i).sendKeys(del);
            }catch (StaleElementReferenceException ignored){ }
        }
        ProfileDashboard.updateButtonClick("Profile changes saved");
    }

    @Test
    public void fillCompany() throws IOException {
        login.login();
        dashboardNavigation.moveToProfile();
        ProfileDashboard.selectMenu("Company");
        SetMethod.EnterText("name","TestOrganization",PropertyType.Name);
        SetMethod.EnterText("organizationalunit","TestOrganizationalunit",PropertyType.Name);
        SetMethod.EnterText("email","Test@Email.com",PropertyType.Name);
        SetMethod.EnterText("phone","45645645611",PropertyType.Name);
        dashboardInstalation.chooseCountryAI();
        SetMethod.EnterText("state","TestState",PropertyType.Name);
        SetMethod.EnterText("city","TestCity",PropertyType.Name);
        SetMethod.EnterText("locality","TestLlocality",PropertyType.Name);
        SetMethod.EnterText("postcode","2052231124",PropertyType.Name);
        SetMethod.EnterText("address1","TestAddress1",PropertyType.Name);
        SetMethod.EnterText("address2","TestAddress2",PropertyType.Name);
        ProfileDashboard.submitButtonClick("Company was saved successfully");
    }
    @Test  // Удаляет все поля кроме обязательных и Phone .
    public void clearCompany() throws IOException, InterruptedException {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        login.login();
        dashboardNavigation.moveToProfile();
        ProfileDashboard.selectMenu("Company");
        List<WebElement> allField = PropertiesCollection.GetDrivers().findElements(By.xpath("//input"));

        for (int i = 1; i <allField.size() ; i++) {
            Thread.sleep(1000);
           try {
               if (!(allField.get(i).getAttribute("value").isEmpty() || i == 2 )) allField.get(i).sendKeys(del);
           }catch (StaleElementReferenceException ignored){ }
        }
        ProfileDashboard.submitButtonClick("Company was saved successfully");
    }

    @Test
    public void connectGitAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Github");
    }

    @Test
    public void connectFacebookAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Facebook");
    }

//    @Test
    public void connectBitbucketAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Bitbucket");
    }

//    @Test
    public void connectLinkedInAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("LinkedIn");
    }

//    @Test
    public void connectGitLabAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("GitLab");
    }

//    @Test
    public void connectAmazonAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Amazon");
    }

//    @Test
    public void connectDigitalOceanAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Digital Ocean");
    }

//    @Test
    public void connectLinodeAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Linode");
    }

//    @Test
    public void connectGoogleCloudAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Google Cloud");
    }

//    @Test
    public void connectMicrosoftAzureAccount() throws Exception {
        ProfileDashboard.connectSocialAccounts("Microsoft Azure");
    }

    @AfterClass
    public static void CleanUp() {
        try {
            if (PropertiesCollection.GetDrivers() != null) {
                PropertiesCollection.GetDrivers().close();
            }
        } catch (TimeoutException | NoSuchSessionException ignored) {

        }
    }
}
