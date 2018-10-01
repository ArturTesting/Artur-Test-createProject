package tryDirect.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import tryDirect.*;
import tryDirect.Tests.profile.ProfileDashboard;

import java.util.List;

public class CloudProvider {
    Helper helper = new Helper();
    private Login login=new Login();
    private DashboardInstalation dashboardInstalation = new DashboardInstalation();
    DashboardNavigation navigation=new DashboardNavigation();


    @Test
    public void checkAllProvider()throws Exception{
        login.login();

        DashboardNavigation navigation=new DashboardNavigation();
        navigation.installButtonClick("Mautic Formula");

        List<WebElement> cloudProvider= PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));

        for(int i=0; i<cloudProvider.size(); i++){
            cloudProvider= PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));
            String href=cloudProvider.get(i).findElement(By.xpath("a")).getAttribute("href");
            cloudProvider.get(i).click();
            if(!helper.checkURL(href)) Assert.fail();
        }
    }

    @Test
    public void installCompanyModalChecking()throws Exception{
        login.login();
        navigation.moveToProfile();
        ProfileDashboard.selectMenu("Company");
        Thread.sleep(1000);
        String organizationalunit = GetMethod.getTextFromInputAttribute("organizationalunit", PropertyType.Name, AttributeType.value);
        String locality = GetMethod.getTextFromInputAttribute("locality", PropertyType.Name, AttributeType.value);
        String state = GetMethod.getTextFromInputAttribute("state", PropertyType.Name, AttributeType.value);

         if ( organizationalunit.equals("") || locality.equals("") || state.equals("") ){
            SetMethod.Click("//a[text()=\"Home\"]", PropertyType.XPath);
            navigation.installButtonClick("Mautic Formula");
            navigation.chooseCloudProvider("Upcloud");
            dashboardInstalation.choosingSSL("Self signed");
            Thread.sleep(1000);
            Assert.assertNotEquals("Ошибка, Модальное окно не появилось ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
            System.out.println("Модальное окно появилось");
        }else {
            SetMethod.Click("//a[text()=\"Home\"]", PropertyType.XPath);
            navigation.installButtonClick("Mautic Formula");
            navigation.chooseCloudProvider("Upcloud");
            dashboardInstalation.choosingSSL("Self signed");
            Assert.assertEquals("Ошибка, Модальное окно не должно появлятся ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
            System.out.println("Компание заполнена , модальное окно не открывается ");
        }
    }

    @Test
    public void installBillingModalChecking()throws Exception{
        login.login();
        navigation.moveToProfile();
        ProfileDashboard.selectMenu("Billing address");
        Thread.sleep(2000);
        String address1 = GetMethod.getTextFromInputAttribute("billing_address_1", PropertyType.Name, AttributeType.value);
        String address2 = GetMethod.getTextFromInputAttribute("billing_address_2", PropertyType.Name, AttributeType.value);
        String city = GetMethod.getTextFromInputAttribute("billing_city", PropertyType.Name, AttributeType.value);
        String countryArea = GetMethod.getTextFromInputAttribute("billing_country_area", PropertyType.Name, AttributeType.value);

         if ( address1.equals("") || address2.equals("") || city.equals("") || countryArea.equals("")){
            SetMethod.Click("//a[text()=\"Stacks\"]", PropertyType.XPath);
            SetMethod.EnterText("//input[@class='form-control']", "fla", PropertyType.XPath);
            navigation.installButtonClickBB(" Install now ");
            navigation.chooseCloudProvider("Amazon EC2");
            Thread.sleep(1000);
            Assert.assertNotEquals("Ошибка, Модальное окно не появилось ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
            System.out.println("Биллинг не заполнен. Модальное окно появилось");
        }else {
            SetMethod.Click("//a[text()=\"Stacks\"]", PropertyType.XPath);
            SetMethod.EnterText("//input[@class='form-control']", "fla", PropertyType.XPath);
            navigation.installButtonClickBB(" Install now ");
            navigation.chooseCloudProvider("Amazon EC2");
            Assert.assertEquals("Ошибка, Модальное окно не должно появлятся ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
            System.out.println("Билинг заполнен , модальное окно не открывается ");
        }
    }

    boolean checkURL(String href) {
        List<String> data = PropertiesCollection.pageInfo();
        PropertiesCollection.GetDrivers().navigate().back();
        return data.get(0).contains(href);
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
