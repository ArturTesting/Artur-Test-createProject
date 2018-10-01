package tryDirect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PropertiesCollection {

    private static WebDriver driver;
    private static String login;
    private static String password;

    public static String[] fileReader(String fileName) throws FileNotFoundException {
        String[] dataArray = new String[10];
        File file = new File("./" + fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                int i = 0;
                while ((s = in.readLine()) != null) {
                    dataArray[i] = s;
                    i++;
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataArray;
    }

    public static void setLogin(String log) {
        login = log;
    }

    public static String getLogin() {
        return login;
    }

    public static void setPassword(String pas) {
        password = pas;
    }

    public static String getPassword() {
        return password;
    }



    public static void Sleep(long x) {
        try {
            Thread.sleep(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SetDrivers(WebDriver dr) {
        driver = dr;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    public static WebDriver GetDrivers() {
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }



    public static Boolean WaitElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(PropertiesCollection.GetDrivers(), 15, 500);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("элемент" + locator + "не прокликивается");
            return false;
        }
    }
    public static Boolean WaitElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(PropertiesCollection.GetDrivers(), 10, 500);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("элемент" + element + "не прокликивается");
            return false;
        }
    }

    private static String getRequestCode(String setUrl) throws IOException {

        try {
            URL url = new URL(setUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            return String.valueOf(connection.getResponseCode());
        } catch (Exception e) {

            return null;
        }
    }

    public static List<String> pageInfo() {
        String url;
        String codeStatus="";
        List<String> urlDate = new ArrayList<>();

        url = PropertiesCollection.GetDrivers().getCurrentUrl();
        try {
            codeStatus = PropertiesCollection.getRequestCode(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        urlDate.add(url);
        urlDate.add(codeStatus);

//        System.out.println("Открыта страница " + url + "\r\n" + "Код возвращаемый страницей " + codeStatus);

        return urlDate;
    }

    public boolean checkCloudProviderURL(String cloudProviderTitle)throws Exception{

        Map<String, String> urlMap=new HashMap<String, String>();
        urlMap.put("Launch on your own server","#/cloud/own/");
        urlMap.put("Scaleway","#/cloud/scw/");
        urlMap.put("Digital Ocean","#/cloud/do/");
        urlMap.put("Linode","#/cloud/lo/");
        urlMap.put("VULTR","#/cloud/vu/");
        urlMap.put("IBM","#/cloud/ibm/");
        urlMap.put("Google Cloud","#/cloud/gc/");
        urlMap.put("Amazon EC2","#/cloud/aws/");

        return true;
    }
}
