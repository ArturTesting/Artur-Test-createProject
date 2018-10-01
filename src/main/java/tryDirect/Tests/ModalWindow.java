package tryDirect.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import tryDirect.*;
import tryDirect.Tests.profile.ProfileTest;



public class ModalWindow {
    private DashboardInstalation dashboardInstalation = new DashboardInstalation();
    private ProfileTest moveToCompany = new ProfileTest();
    DashboardNavigation navigation=new DashboardNavigation();


    @Test
    public void FullCompanyModalChecking()throws Exception{
        moveToCompany.fillCompany();  // Заполнение компании
        SetMethod.Click("//span[@class = 'notification-dismiss']",PropertyType.XPath);
        Thread.sleep(1000);

            SetMethod.Click("//a[text()=\"Home\"]", PropertyType.XPath);
            navigation.installButtonClick("Mautic Formula");
            navigation.chooseCloudProvider("Upcloud");
            dashboardInstalation.choosingSSL("Self signed");
            Assert.assertEquals("Ошибка, Модальное окно не должно появлятся ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
            System.out.println("Компание заполнена , модальное окно не открывается ");
            CleanUp();
    }

    @Test
    public void EmptyCompanyModalChecking()throws Exception {
        moveToCompany.clearCompany(); // Очищение компании
        SetMethod.Click("//span[@class = 'notification-dismiss']", PropertyType.XPath);
        Thread.sleep(1000);

            SetMethod.Click("//a[text()=\"Home\"]", PropertyType.XPath);
            navigation.installButtonClick("Mautic Formula");
            navigation.chooseCloudProvider("Upcloud");
            dashboardInstalation.choosingSSL("Self signed");
            Thread.sleep(1000);
        Assert.assertNotEquals("Ошибка, Модальное окно не появилось ",0,PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
        System.out.println("Модальное окно появилось");
        CleanUp();
    }


    @Test
    public void FullBillingModalChecking()throws Exception{
        ToolsForModalWindow.actionsWithBillingAndMovingToStack("fill");
        CleanUp();
    }
    @Test
    public void EmptyBillingModalChecking()throws Exception{
        ToolsForModalWindow.actionsWithBillingAndMovingToStack("");
        CleanUp();
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
