package tryDirect.Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;

import java.util.List;

public class DashboardNavigation {
    void installButtonClick(String serviceName){
        List<WebElement> buttonArray= PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix' and .//a[contains(text(), '"+serviceName+"')]]//button"));
        buttonArray.get(0).sendKeys();
        buttonArray.get(0).click();
    }
    void installButtonClickBB(String serviceName){
        List<WebElement> buttonArray= PropertiesCollection.GetDrivers().findElements(By.xpath("//button[contains(text(), '"+serviceName+"')]"));
        buttonArray.get(0).sendKeys();
        buttonArray.get(0).click();
    }

    void chooseCloudProvider(String cloudName){
        switch (cloudName) {
            case "Vultr":
                PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li//img[contains(@src, '/img/partners/vultr.png')]//..")).get(0).click();
                break;
            case "IBM":
                PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li//img[contains(@src, '/img/partners/softlayer.jpg')]//..")).get(0).click();
                break;
            case "Upcloud":
                PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li//img[contains(@src, '/img/partners/upcloud.png')]//..")).get(0).click();
                break;
            default:
                PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li//b[contains(text(),'" + cloudName + "')]")).get(0).click();
                break;
        }
    }

    void chouseCloudProviderOnINSTALL (int cloudNumber){
        PropertiesCollection.GetDrivers().findElement(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li["+cloudNumber+"]")).click();
    }

       public void moveToProfile(){
        SetMethod.Click("//button/i[@class='fas fa-cog']", PropertyType.XPath);
        SetMethod.Click("//ul[@class='dropdown-menu']/li[1]", PropertyType.XPath);
    }

    public void notificationsText(String notificationText){
        try {
            WebDriverWait wait = new WebDriverWait(PropertiesCollection.GetDrivers(), 10);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='notification-message']"),notificationText));

        } catch (Exception ignored) {
            System.out.println("Нотифи  с указанным текстом не появилась");
            Assert.fail();
        }
    }
    public void checkingTheSarchFunction (String searchObject){
        SetMethod.EnterText("//input[contains(@placeholder, \"Search\")]",searchObject,PropertyType.XPath);
        SetMethod.Click("//span[@class=\"input-group\"]//button",PropertyType.XPath);
    }
}
