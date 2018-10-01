package tryDirect.Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tryDirect.PropertiesCollection;
import tryDirect.PropertyType;
import tryDirect.SetMethod;
import tryDirect.Tests.profile.ProfileTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolsForModalWindow {
   public static DashboardNavigation navigation = new DashboardNavigation();
   public static ProfileTest move = new ProfileTest();
   private static String providerName(int numberName){
        Map<Integer, String> providerName = new HashMap<>();
        providerName.put(1, "Amazon");
        providerName.put(2, "Google Cloud");
        providerName.put(3, "Upcloud");
        providerName.put(4, "Digital Ocean");
        providerName.put(5, "Linode");
        providerName.put(6, "IBM");
        providerName.put(7, "Vultr");
        providerName.put(8, "Scaleway");
        providerName.put(9, "Own");
        return providerName.get(numberName);
    }

    static void actionsWithBillingAndMovingToStack(String fields) throws Exception {
        if (fields.equals("fill")) {
            move.fillBilling();  // Заполнение Биллинга
            SetMethod.Click("//span[@class = 'notification-dismiss']", PropertyType.XPath);
            PropertiesCollection.GetDrivers().get("https://dev.try.direct/#/cloud/flask-formula?_k=l25rp6");
            checkInAllProviders(fields);
        } else {
            move.clearBilling();  // Удаление Биллинга
            SetMethod.Click("//span[@class = 'notification-dismiss']", PropertyType.XPath);
            PropertiesCollection.GetDrivers().get("https://dev.try.direct/#/cloud/flask-formula?_k=l25rp6");
            checkInAllProviders(fields);
        }
   }

    private static void checkInAllProviders(String checkOnFill) {
        if (checkOnFill.equals("fill")) {

            List<WebElement> cloudProvider= PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));
            List<AssertionError> errors = new ArrayList<>();
            for (int i = 1, size = cloudProvider.size(); i <= size; i++) {
                navigation.chouseCloudProviderOnINSTALL(i);
                try {
                    Assert.assertEquals(providerName(i) + ": Ошибка, Модальное окно не должно появлятся ", 0, PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
                    System.out.println(providerName(i) + ": Биллинг заполнен , модальное окно не открывается ");
                } catch (AssertionError assertionError) {
                    errors.add(assertionError);
                }
                PropertiesCollection.GetDrivers().navigate().back();
            }
            if (errors.size() > 0) {
                for (AssertionError error : errors) {
                    System.out.println(error);
                }
                Assert.fail();
            }
        } else {
            List<WebElement> cloudProvider= PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class='clearfix text-center']//ul[@class='hide-bullets']/li"));
            List<AssertionError> errors = new ArrayList<>();
            for (int i = 1, size = cloudProvider.size(); i <= size; i++) {
                navigation.chouseCloudProviderOnINSTALL(i);
                try {
                    Assert.assertNotEquals(providerName(i) + ": Ошибка, Модальное окно не появилось ", 0, PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"modal-content\"]")).size());
                    System.out.println(providerName(i) + ": Биллинг очищен, Модальное окно появилось ");
                } catch (AssertionError assertionError) {
                    errors.add(assertionError);
                }
                PropertiesCollection.GetDrivers().navigate().back();
            }
            if (errors.size() > 0) {
                for (AssertionError error : errors) {
                    System.out.println(error);
                }
                Assert.fail();
            }
        }
    }
}
