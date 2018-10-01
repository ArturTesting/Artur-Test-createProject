package tryDirect.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import tryDirect.Connect;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;
import tryDirect.Tests.registration.Registration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Breadcrumbs {

    private Helper helper=new Helper();

    @BeforeClass
    public static void connect() throws FileNotFoundException {
        Registration.Connect();
    }

    @Test
    public void signIn() throws IOException {
        String breadcrambsText="";

        Connect.connect();

        System.out.println("Нажатие на кнопку Sign Ip");
        SetMethod.Click("//*[contains(text(), ' Sign in')]", PropertyType.XPath);
        List<WebElement> tabs = PropertiesCollection.GetDrivers().findElement(By.className("breadcrumb")).findElements(By.tagName("li"));

        for (WebElement tab : tabs) {
             breadcrambsText+=tab.getText()+'/';
        }
        breadcrambsText=breadcrambsText.substring(0,breadcrambsText.length()-1);
        if(helper.compare(breadcrambsText, "Home/Account/Sign In")){System.out.println("Хлебные крошки для Sing In отображенны корректно ");
        }
    }

    @Test
    public void signUp() throws IOException {
        String breadcrambsText="";

        Connect.connect();

        System.out.println("Нажатие на кнопку Sign Up");
        SetMethod.Click("//*[contains(text(), ' Sign up')]", PropertyType.XPath);
        List<WebElement> tabs = PropertiesCollection.GetDrivers().findElement(By.className("breadcrumb")).findElements(By.tagName("li"));

        for (WebElement tab : tabs) {
            breadcrambsText+=tab.getText()+'/';
        }
        breadcrambsText=breadcrambsText.substring(0,breadcrambsText.length()-1);
        if(helper.compare(breadcrambsText, "Home/Account/Sign Up")){System.out.println("Хлебные крошки для Sing Up отображенны корректно ");
        }
    }

    @Test
    public void stacks() throws IOException {
        String breadcrambsText="";

        Connect.connect();

        System.out.println("Нажатие на кнопку Stack");
        SetMethod.Click("//*[contains(text(), 'Stacks')]", PropertyType.XPath);
        List<WebElement> tabs = PropertiesCollection.GetDrivers().findElement(By.className("breadcrumb")).findElements(By.tagName("li"));

        for (WebElement tab : tabs) {
            breadcrambsText+=tab.getText()+'/';
        }
        breadcrambsText=breadcrambsText.substring(0,breadcrambsText.length()-1);
        if(helper.compare(breadcrambsText, "Home/Applications")){System.out.println("Хлебные крошки для Stacks отображенны корректно ");
        }
    }

    @Test
    public void mauticFormula() throws IOException {
        String breadcrambsText="";

        Login login=new Login();
        login.login();

        PropertiesCollection.GetDrivers().findElement(By.id("mautic-formula")).sendKeys();
        System.out.println("Нажатие на Mautic Formula");
        DashboardNavigation navigation=new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");

        List<WebElement> tabs = PropertiesCollection.GetDrivers().findElement(By.className("breadcrumb")).findElements(By.tagName("li"));

        for (WebElement tab : tabs) {
            breadcrambsText+=tab.getText()+'/';
        }
        breadcrambsText=breadcrambsText.substring(0,breadcrambsText.length()-1);
        if(helper.compare(breadcrambsText, "Home/Cloud")){System.out.println("Хлебные крошки для Mautic Formula отображенны корректно ");
        }
    }

    @Test
    public void digitalOcean() throws IOException {
        String breadcrambsText="";



        Login login=new Login();
        login.login();
        DashboardNavigation navigation=new DashboardNavigation();

       // PropertiesCollection.GetDrivers().findElement(By.id("mautic-formula")).sendKeys();
        System.out.println("Нажатие на Mautic Formula");
        navigation.installButtonClick("Mautic formula");
        System.out.println("Нажатие на  Digital Ocean");
        navigation.chooseCloudProvider("Digital Ocean");


        List<WebElement> tabs = PropertiesCollection.GetDrivers().findElement(By.className("breadcrumb")).findElements(By.tagName("li"));

        for (WebElement tab : tabs) {
            breadcrambsText+=tab.getText()+'/';
        }
        breadcrambsText=breadcrambsText.substring(0,breadcrambsText.length()-1);
        if(helper.compare(breadcrambsText, "Home/Install in the Cloud/Install at Digital Ocean")){System.out.println("Хлебные крошки для Digital Ocean отображенны корректно ");
        }
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
