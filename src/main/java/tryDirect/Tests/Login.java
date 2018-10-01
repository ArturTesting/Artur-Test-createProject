package tryDirect.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import tryDirect.*;
import tryDirect.Tests.registration.Registration;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Login {

    GetPropertyValues propertyValues = new GetPropertyValues();
    @BeforeClass
    public static void connect() throws FileNotFoundException {
      Registration.Connect();
    }

    @Test
    public void login() throws IOException {
        Connect.connect();
        String login=PropertiesCollection.getLogin();
        String password=PropertiesCollection.getPassword();

        System.out.println("Нажатие на кнопку Sign Ip");
        SetMethod.Click("//*[contains(text(), ' Sign in')]", PropertyType.XPath);
        System.out.println("Заполнение поля email значением "+login);
        SetMethod.EnterText("email", login, PropertyType.Name);
        System.out.println("Заполнение поля password значением "+password);
        SetMethod.EnterText("password", password, PropertyType.Name);
        System.out.println("Нажатие на кнопку Sign In");
        SetMethod.Click("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[3]/div/div/div/form/div[5]/div/div/button", PropertyType.XPath);
    }

    void faceBookLogin(){
        SetMethod.EnterText("email","developer.optimum@gmail.com", PropertyType.Name);
        SetMethod.EnterText("pass", "evtyz5gfhjktq", PropertyType.Name);
        SetMethod.Click("login", PropertyType.Name);
    }

    public void gitLogin() throws IOException {
        SetMethod.EnterText("login", propertyValues.getGitLogin(), PropertyType.Name);
        SetMethod.EnterText("password", propertyValues.getGitPassword(), PropertyType.Name);
        SetMethod.Click("commit", PropertyType.Name);
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
