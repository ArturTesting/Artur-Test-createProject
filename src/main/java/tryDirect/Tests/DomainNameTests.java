package tryDirect.Tests;

import org.junit.*;
import org.openqa.selenium.*;
import tryDirect.*;
import tryDirect.Tests.registration.Registration;

import java.io.FileNotFoundException;
import java.util.List;

public class DomainNameTests {

    @BeforeClass
    public static void connect() throws FileNotFoundException {
        Registration.Connect();
    }

    @Test
    public void fillingAndClearDomainNameSuccess() throws Exception{
        Login login = new Login();
        login.login();
        DashboardInstalation instalation = new DashboardInstalation();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        boolean bool = true;

        List<WebElement> cloudProvider = PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));

        for (int i = 0; i < cloudProvider.size(); i++) {
            cloudProvider = PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));
            String href = cloudProvider.get(i).findElement(By.xpath("a")).getAttribute("href");
            String cloudTitle = cloudProvider.get(i).getText();
            cloudProvider.get(i).click();
//            Thread.sleep(1000);
            instalation.fillingDomainName("asdss.com");
//            Thread.sleep(1000);
            String value = GetMethod.getTextFromInputAttribute("//input[@class='commonDomain padd-input-control form-control']", PropertyType.XPath, AttributeType.value);
            for (int j = 0; j < value.length(); j++) {
                PropertiesCollection.GetDrivers().findElement(By.xpath("//input[@class='commonDomain padd-input-control form-control']")).sendKeys(Keys.BACK_SPACE);
            }

            value = GetMethod.getTextFromInputAttribute("//input[@class='commonDomain padd-input-control form-control']", PropertyType.XPath, AttributeType.value);
            try {
                Assert.assertEquals("Domain name failed " + cloudTitle, "", value);
                bool = false;
            } catch (ComparisonFailure ignored) {
                System.out.println(ignored);
            }

//            instalation.fillingDomainName("");
//            PropertiesCollection.Sleep(3000);
            if (!checkURL(href)) Assert.fail();
        }
        if(bool)Assert.fail();
        CleanUp();

    }
    boolean checkURL(String href) {
        List<String> data = PropertiesCollection.pageInfo();
        PropertiesCollection.GetDrivers().navigate().back();
        return data.get(0).contains(href);
    }

    @Test
    public void mauticFormulasOWNtest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Launch on your own server");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL();
        dashboardInstalation.fillingIPaddress();
        dashboardInstalation.fillingServerLogin();
        dashboardInstalation.fillingSSHpassword();
        String str = "";
        CleanUp();

    }
    @Test
    public void mauticFormulasScalewayTest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Scaleway");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL();
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.chooseServer();
        dashboardInstalation.fillingAccessKey();
        dashboardInstalation.fillingToken();
        String str = "";
        CleanUp();

    }
    @Test
    public void mauticFormulasDOtest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic Formula");
        navigation.chooseCloudProvider("Digital Ocean");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL();
        dashboardInstalation.chooseRegion();
        dashboardInstalation.choosingRAM("4Gb");
        dashboardInstalation.chooseDroplesDOS();
        CleanUp();

    }
    @Test
    public void mauticFormulasLinodeTest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Linode");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL("No SSL");
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.chooseServer("Linode 96GB");
        dashboardInstalation.fillingToken();
        String str = "";
        CleanUp();

    }
    @Test
    public void mauticFormulasVultrTest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Vultr");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL("No SSL");
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.chooseServer();
        dashboardInstalation.fillingToken();
        CleanUp();

    }
    @Test
    public void mauticFormulasIBMSoftLayerTest() throws Exception{
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("IBM");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL("No SSL");
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.choosingRAM("2Gb");
        dashboardInstalation.choosingDiskSize("25Gb");
        dashboardInstalation.choosingCPU("2");
        dashboardInstalation.fillingApiKey();
        dashboardInstalation.fillingUsername();
        String str = "";
        CleanUp();

    }
    @Test
    public void mauticFormulasGoogleCloudTest() throws Exception{
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Google Cloud");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL("No SSL");
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.choosingDiskSize("50Gb");
        dashboardInstalation.chooseServer();
        dashboardInstalation.choosePersistentDisk();
        dashboardInstalation.fillingProjectID();
        String str = "";
        CleanUp();

    }
    @Test
    public void mauticFormulasAmazonTest() throws Exception {
        Login authorized = new Login();
        authorized.login();
        DashboardNavigation navigation = new DashboardNavigation();
        navigation.installButtonClick("Mautic formula");
        navigation.chooseCloudProvider("Amazon EC2");
        DashboardInstalation dashboardInstalation = new DashboardInstalation();
        dashboardInstalation.fillingDomainName();
        dashboardInstalation.customizeDomainNames();
        dashboardInstalation.choosingSSL("No SSL");
        dashboardInstalation.chooseRegion();
        dashboardInstalation.chooseDroplesDOS();
        dashboardInstalation.chooseServer();
        dashboardInstalation.fillingAccessKey();
        dashboardInstalation.fillingConsumerSecret();
        String str = "";
        CleanUp();
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
