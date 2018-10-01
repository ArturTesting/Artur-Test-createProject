package tryDirect.Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tryDirect.Connect;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;

import java.io.IOException;

public class Request {

//    @Test
    public void requestCustomStack() throws IOException {
        Connect.connect();

        PropertiesCollection.Sleep(1000);
        SetMethod.EnterText("//input[@type='text']", "test", PropertyType.XPath);
        PropertiesCollection.Sleep(1000);
        SetMethod.EnterText("//input[@type='email']", "test@test", PropertyType.XPath);
        PropertiesCollection.Sleep(1000);
//        SetMethod.Click("//div[@class='recaptcha-checkbox-checkmark']", PropertyType.XPath);
        PropertiesCollection.GetDrivers().findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.TAB, Keys.SPACE);
        String asd="";
    }
}
