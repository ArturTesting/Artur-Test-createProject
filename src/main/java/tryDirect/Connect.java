package tryDirect;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Connect {
    public static void connect() throws IOException {
        GetPropertyValues propertyValues = new GetPropertyValues(); // Значения по умаолчанию в Классе из config.properties

        // Задает Логин, Пароль и Дравйвер в PropertiesCollection и открывает сайт ТД
        PropertiesCollection.setLogin(propertyValues.getLogin());
        PropertiesCollection.setPassword(propertyValues.getPassword());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1900,1000");
        PropertiesCollection.SetDrivers(new ChromeDriver(options));
//        System.out.println("Открытие браузера на странице TD");
        PropertiesCollection.GetDrivers().get(propertyValues.getUrl()); // используем это драйвер для открытия сайта TD
    }
}
