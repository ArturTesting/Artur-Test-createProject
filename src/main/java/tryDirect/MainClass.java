package tryDirect;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
       // DomainNameTests mauticFormula=new DomainNameTests();
      //  mauticFormula.mauticFormulaTest();

        GetPropertyValues propertyValues=new GetPropertyValues();

        PropertiesCollection.setLogin(propertyValues.getLogin());
        PropertiesCollection.setPassword(propertyValues.getPassword());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1600,900");
        PropertiesCollection.SetDrivers(new ChromeDriver(options));
//        System.out.println("Открытие браузера на странице TD");
        PropertiesCollection.GetDrivers().get(propertyValues.getUrl());
    }
}
