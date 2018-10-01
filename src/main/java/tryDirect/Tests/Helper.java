package tryDirect.Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;

import java.io.IOException;
import java.util.List;

public class Helper {
    public void registrationVia(String serviceName) throws IOException {
        Login login=new Login();
        SetMethod.Click("//*[contains(text(), ' Sign up')]", PropertyType.XPath);

        switch (serviceName){
            case "faceBook":
                SetMethod.Click("//i[@class='fa fa-facebook social-icon white']", PropertyType.XPath);
                login.faceBookLogin();
                SetMethod.EnterText("password","0123456", PropertyType.Name);
                SetMethod.EnterText("repeat_password","0123456",PropertyType.Name);
                SetMethod.Click("//*[contains(text(), 'Submit')]", PropertyType.XPath);

//                 My Account
                if(SetMethod.IsElementExists(By.xpath("//*[contains(text(), 'My Account')]"))) {
                    String str="";
                }
                else Assert.fail();
                break;
            case "git":
                SetMethod.Click("//i[@class='fab fa-github social-icon']", PropertyType.XPath);
                login.gitLogin();

                SetMethod.EnterText("password","12345678", PropertyType.Name);
                SetMethod.EnterText("repeat_password","12345678",PropertyType.Name);
                SetMethod.Click("//*[contains(text(), 'Submit')]", PropertyType.XPath);

                if(SetMethod.IsElementExists(By.xpath("//*[contains(text(), 'My Account')]"))) {
                    String str="";
                }
                else Assert.fail();
                break;
        }
    }

    boolean compare(String firstTitle, String secondTitle) {
        return firstTitle.equals(secondTitle);
    }

    public void getAllCloudProvider(){
        PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li/"));
        String str="";
    }
    boolean checkURL(String href){
        List<String> data=PropertiesCollection.pageInfo();
        PropertiesCollection.GetDrivers().navigate().back();
        return data.get(0).contains(href);
    }

}
