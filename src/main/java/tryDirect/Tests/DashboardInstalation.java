package tryDirect.Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tryDirect.*;

import java.util.Random;

public class DashboardInstalation {
    private Random rnd = new Random();

    void fillingIPaddress() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@class=\"form-control padd-input-control form-control\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@class=\"form-control padd-input-control form-control\"]", "123.1.12.12", PropertyType.XPath);
    }
    void fillingProjectID() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@class=\"padd-input-control form-control\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@class=\"padd-input-control form-control\"]", "aasdaddadsaaaaaaa", PropertyType.XPath);
        System.out.println("Введение ProjectID");
    }
    void fillingServerLogin() throws Exception{
        if (!SetMethod.IsElementExists(By.xpath("//input[@class=\"padd-input-control form-control\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@class=\"padd-input-control form-control\"]", "arti996@yandex.ru", PropertyType.XPath);

    }
    void fillingSSHpassword() throws Exception{
        if (!SetMethod.IsElementExists(By.xpath("//a[@id=\"own-form-access-tab-2\"]")))
            throw new Exception();
        SetMethod.Click("//a[@id=\"own-form-access-tab-2\"]",PropertyType.XPath);
        if (!SetMethod.IsElementExists(By.name("password")))
            throw new Exception();
        SetMethod.EnterText("password", "12345678", PropertyType.Name);
    }
    void fillingAccessKey() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@placeholder=\"ACCESS KEY\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@placeholder=\"ACCESS KEY\"]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Access Key'");
    }
    void fillingApiKey() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[contains(@placeholder, \"Key\")]")))
            throw new Exception();
        SetMethod.EnterText("//input[contains(@placeholder, \"Key\")]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Api Key'");
    }
    void fillingAccessKeyID() throws Exception{
        SetMethod.EnterText("//input[contains(@placeholder, \"Access key ID\")]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Access key ID'");
    }
    void fillingSecretAccessKey() throws Exception{
        SetMethod.EnterText("//input[contains(@placeholder, \"Secret access key\")]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Secret Access Key'");
    }

    void fillingUsername() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@placeholder=\"Username\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@placeholder=\"Username\"]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Username'");
    }
    void fillingToken() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@placeholder=\"TOKEN\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@placeholder=\"TOKEN\"]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Token'");
    }
    void fillingConsumerSecret() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@placeholder=\"SECRET\"]")))
            throw new Exception();
        SetMethod.EnterText("//input[@placeholder=\"SECRET\"]", "yhyhthtyhtyhtyhtyhtyhty", PropertyType.XPath);
        System.out.println("Введение 'Consumer Secret'");
    }
    void fillingDomainName() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@class='commonDomain padd-input-control form-control']")))
            throw new Exception();
        SetMethod.EnterText("//input[@class='commonDomain padd-input-control form-control']", "art.test.com", PropertyType.XPath);
        System.out.println("Введение имя домена");
    }
    void fillingDomainName(String domainName) throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//input[@class='commonDomain padd-input-control form-control']")))
            throw new Exception();
        SetMethod.EnterText("//input[@class='commonDomain padd-input-control form-control']", domainName, PropertyType.XPath);
        System.out.println("Введенное имя домена = "+domainName);
    }

    void chooseServer() throws Exception {
//        List<WebElement> serverList=PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='panel-body' and (.//*[contains(text(), 'Choose Server')])]//li/div")).get(0).getText();
        if (!SetMethod.IsElementExists(By.xpath("//div[contains(@class, \"server\")]/..")))
            throw new Exception();
        SetMethod.Click("//div[@class='panel-body' and (.//*[contains(text(), 'Choose Server')])]//li[" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='panel-body' and (.//*[contains(text(), 'Choose Server')])]//li")).size()) + 1) + "]", PropertyType.XPath);
        System.out.println("Выбор 'Server' ");
    }
    void chooseServer(String nameServer) throws Exception{
        if (!SetMethod.IsElementExists(By.xpath("//div[@class='panel-body' and (.//*[contains(text(), 'Choose Server')])]//li//div[contains(text(), '"+nameServer+"')]")))
            throw new Exception();
        SetMethod.Click("//div[@class='panel-body' and (.//*[contains(text(), 'Choose Server')])]//li//div[contains(text(), '"+nameServer+"')]", PropertyType.XPath);
        System.out.println("Выбор 'Server' "+nameServer);

    }
    void choosePersistentDisk() throws Exception {
        if (!SetMethod.IsElementExists(By.xpath("//div[@class=\"col-md-3 col-xs-12\"]//div[@class=\"form-group\"]/div/label")))
            throw new Exception();
        SetMethod.Click("//div[@class=\"col-md-3 col-xs-12\"]//div[@class=\"form-group\"]/div/label[" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"col-md-3 col-xs-12\"]//div[@class=\"form-group\"]/div/label")).size()) + 1) + "]", PropertyType.XPath);
        System.out.println("Выбор 'PersistentDisk' ");
    }
    static void choosingSSL() throws Exception {
        Random rnd = new Random();
        if (!SetMethod.IsElementExists(By.name("ssl"))) throw new Exception();
//        SetMethod.Click("ssl", PropertyType.Name);
        PropertiesCollection.Sleep(1000);
        SetMethod.Click("//select[@name='ssl']/option[" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//select[@name='ssl']/option")).size()) + 1) + "]", PropertyType.XPath);
    }
    void choosingSSL(String sslName) throws Exception {
        if (!SetMethod.IsElementExists(By.name("ssl"))) throw new Exception();
//        SetMethod.Click("ssl", PropertyType.Name);
        SetMethod.Click("//select[@name='ssl']/option[contains(text(),'" + sslName + "')]", PropertyType.XPath);
        System.out.println("Выбор 'SSL' ");

    }
    void choosingRAM(String ramSize) throws Exception {
        SetMethod.Click("//label[contains(text(), \"RAM Size\")]//..//div[@class=\"rc-slider-mark\"]/span[contains(text(), '" + ramSize + "')]", PropertyType.XPath);
        System.out.println("Выбор 'RAM Size' ");
    }
    void choosingDiskSize(String diskSize) throws Exception {
        SetMethod.Click("//label[contains(text(), \"Disk Size\")]//..//div[@class=\"rc-slider-mark\"]/span[contains(text(), '" + diskSize + "')]", PropertyType.XPath);
        System.out.println("Выбор 'Disk Size' ");
    }

    void choosingCPU(String cpu) throws Exception {
        SetMethod.Click("//label[contains(text(), \"CPU\")]//..//div[@class=\"rc-slider-mark\"]/span[contains(text(), '" + cpu + "')]", PropertyType.XPath);
        System.out.println("Выбор 'CPU' ");
    }

    void chooseDroplesDOS() throws Exception {
        if (!SetMethod.IsElementExists(By.name("os"))) throw new Exception();
//        List<WebElement> asd=PropertiesCollection.GetDrivers().findElements(By.xpath("//select[@name='os']/option"));
        SetMethod.Click("//select[@name='os']/option[" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//select[@name='os']/option")).size()) + 1) + "]", PropertyType.XPath);
        System.out.println("Выбор 'DroplesOS' ");
    }

    void chooseDroplesDOS(String osName) throws Exception {
        if (!SetMethod.IsElementExists(By.name("os"))) throw new Exception();
        SetMethod.Click("//select[@name='ssl']/option[contains(text(),'" + osName + "')]", PropertyType.XPath);
    }

   public void chooseCountryAI (){
        SetMethod.Click("//select[contains(@class, \"form-control\")]/option[" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//select[contains(@class, \"form-control\")]/option")).size()) + 1) + "]",PropertyType.XPath);
    }
    void installButtonClick() throws Exception {
        SetMethod.Click("//button[@class='btn btn-success btn-lg btn-block']", PropertyType.XPath);
    }

    void chooseRegion() throws Exception {
        SetMethod.Click("//li[contains(@class, \"col-md-2 col-sm-3 col-xs-3\")][" + (rnd.nextInt(PropertiesCollection.GetDrivers().findElements(By.xpath("//li[contains(@class, \"col-md-2 col-sm-3 col-xs-3\")]")).size()) + 1) + "]", PropertyType.XPath);
        System.out.println("Выбор 'Region' ");

    }

    void chooseRegion(String regionTitle) throws Exception {
        SetMethod.Click("//li[contains(@class, \"col-md-2 col-sm-3 col-xs-3\")]//p[contains(text(), '" + regionTitle + "')]", PropertyType.XPath);
    }

    void customizeDomainNames() throws Exception {
        customizeNamesClick();
        System.out.println("Нажатие на 'customizeDomainName' ");

        try {
            WebDriverWait wait = new WebDriverWait(PropertiesCollection.GetDrivers(), 10);
            wait.until(ExpectedConditions.visibilityOf(PropertiesCollection.GetDrivers().findElement(By.xpath("//div[@class='modal-content']//h4[@class='modal-title' and contains(text(), ' Customize subdomain names')]"))));

        } catch (Exception ignored) {
            System.out.println("Форма не появилась");
            Assert.fail();
        }

        fillingStackSubdomains();
        saveButtonClickDomainName();

        try {
            WebDriverWait wait = new WebDriverWait(PropertiesCollection.GetDrivers(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(PropertiesCollection.GetDrivers().findElement(By.xpath("//div[@class='modal-content']//h4[@class='modal-title' and contains(text(), ' Customize subdomain names')]"))));
        } catch (Exception ignored) {
            System.out.println("Форма не закрылась");
            Assert.fail();
        }
    }

    private void fillingStackSubdomains() throws Exception {
        String wpTextDefault = "wp.subTest.com";
        String mauticTextDefault = "mau.subTest.com";
        String suitecrmTextDefault = "suite.subTest.com";
        String mailuTextDefault = "mail.subTest.com";

        SetMethod.EnterText("wordpress", wpTextDefault, PropertyType.Name);
        SetMethod.EnterText("mautic", mauticTextDefault, PropertyType.Name);
        SetMethod.EnterText("suitecrm", suitecrmTextDefault, PropertyType.Name);
        SetMethod.EnterText("mailu", mailuTextDefault, PropertyType.Name);

        checkSubdomainNameAfterFilling(wpTextDefault, mauticTextDefault, suitecrmTextDefault, mailuTextDefault);
    }

    void fillingStackSubdomains(String wpText, String mauticText, String suitecrmText, String mailuText) throws Exception {
        SetMethod.EnterText("wordpress", wpText, PropertyType.Name);
        SetMethod.EnterText("mautic", mauticText, PropertyType.Name);
        SetMethod.EnterText("suitecrm", suitecrmText, PropertyType.Name);
        SetMethod.EnterText("mailu", mailuText, PropertyType.Name);
    }

    private void checkSubdomainNameAfterFilling(String wpText, String mauticText, String suitecrmText, String mailuText) {
        if (!compareDomainName(GetMethod.getTextFromInput("//ul[@class='list-group']/li[.//b[contains(text(), 'wordpress')]]//p", PropertyType.XPath)
                .replaceAll("wordpress: ", ""), wpText)) {
            Assert.fail();
        }
        if (!compareDomainName(GetMethod.getTextFromInput("//ul[@class='list-group']/li[.//b[contains(text(), 'mautic')]]//p", PropertyType.XPath)
                .replaceAll("mautic: ", ""), mauticText)) {
            Assert.fail();
        }
        if (!compareDomainName(GetMethod.getTextFromInput("//ul[@class='list-group']/li[.//b[contains(text(), 'suitecrm')]]//p", PropertyType.XPath)
                .replaceAll("suitecrm: ", ""), suitecrmText)) {
            Assert.fail();
        }
        if (!compareDomainName(GetMethod.getTextFromInput("//ul[@class='list-group']/li[.//b[contains(text(), 'mailu')]]//p", PropertyType.XPath)
                .replaceAll("mailu: ", ""), mailuText)) {
            Assert.fail();
        }
    }

    private boolean compareDomainName(String firstTitle, String secondTitle) {
        return firstTitle.equals(secondTitle);
    }

    private void saveButtonClickDomainName() {
        if (SetMethod.IsElementExists(By.xpath("//button[@class='btn btn-success btn-md text-center' and contains(text(), 'Save')]")))
            SetMethod.Click("//button[@class='btn btn-success btn-md text-center' and contains(text(), 'Save')]", PropertyType.XPath);
    }

    private void customizeNamesClick() throws Exception {
        SetMethod.Click("//div[@class='text-right']//i", PropertyType.XPath);
    }
}
