package tryDirect.Tests.registration;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tryDirect.*;
import tryDirect.Tests.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class Registration {

    @BeforeClass

    public static void Connect() throws FileNotFoundException {

    }

    @Test
    public void registration() throws IOException {
        Connect connect=new Connect();
        connect.connect();

        System.out.println("Нажатие на кнопку Sign Up");
        SetMethod.Click("//*[contains(text(), ' Sign up')]", PropertyType.XPath);
        System.out.println("Заполнение поля first_name значением test first Name");
        SetMethod.EnterText("first_name", "test first Name", PropertyType.Name);
        System.out.println("Заполнение поля last_name значением test line Name");
        SetMethod.EnterText("last_name", "test last Name", PropertyType.Name);
        System.out.println("Заполнение поля email значением lagutenkovvladimir1991@gmail.com");
        SetMethod.EnterText("email", "lagutenkovvladimir1991@gmail.com", PropertyType.Name);
        System.out.println("Заполнение поля password значением 12345678");
        SetMethod.EnterText("password", "12345678", PropertyType.Name);
        System.out.println("Заполнение поля repeat_password 12345678");
        SetMethod.EnterText("repeat_password", "12345678", PropertyType.Name);
        System.out.println("Нажатие на кнопук accept");
        SetMethod.Click("accept", PropertyType.Name);
        System.out.println("Нажатие на кнопку Sign In");
        SetMethod.Click("//button[@class='btn btn-primary btn-outline-primary btn-lg' and contains(text(), 'Sign Up')]", PropertyType.XPath);
        String s = "123";
    }

    @Test
    public void registrationViaFaceBook() throws IOException {
        Connect connect=new Connect(); // открывает сайт ТД
        connect.connect();

        Helper helper=new Helper();
        helper.registrationVia("faceBook");
    }

    @Test
    public void registrationViaGit() throws Exception{
        Connect.connect();

        Helper helper=new Helper();
        helper.registrationVia("git");
    }

    @AfterClass
    public static void CleanUp() {
        PropertiesCollection.GetDrivers().close();
    }
}
