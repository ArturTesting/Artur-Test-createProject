package tryDirect.Tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import tryDirect.*;
import tryDirect.Tests.profile.ProfileTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckingSearchResultsTest {

    @Test
    public void searchTest()throws Exception{
        Connect.connect();
        SetMethod.Click("//a[text()=\"Stacks\"]", PropertyType.XPath);
        SetMethod.EnterText("//input[@class='form-control']", "Odoo123", PropertyType.XPath);
        SetMethod.Click("//span[@class='glyphicon glyphicon-search']", PropertyType.XPath);
        PropertiesCollection.GetDrivers().findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.TAB, Keys.SPACE);
        List<WebElement> stacksAfterSearch = PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"clearfix thumbnail app-box vertical-align padd-0\"]"));
        Assert.assertTrue("The message 'no item Found' is not displayed",stacksAfterSearch.size()==0);
        String asd = "";
    }

    @Test
    public void StackSearchResult() throws Exception{
        String fieldOfSearch = "odoo";
        Connect.connect();

        SetMethod.Click("//a[text()=\"Stacks\"]", PropertyType.XPath);
        ArrayList<String> lowerCaseStackName = new ArrayList<>();
        List<WebElement> allStackBeforeSerch = PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"clearfix thumbnail app-box vertical-align padd-0\"]//div[@style=\"width: 100%;\"]//a"));

        for (int i = 0; i <allStackBeforeSerch.size() ; i++) {
            lowerCaseStackName.add(allStackBeforeSerch.get(i).getText().toLowerCase());
        }
         List<Object> counter = Arrays.asList(lowerCaseStackName.stream().filter(text -> text.contains(fieldOfSearch)).toArray());

        SetMethod.EnterText("//input[@class='form-control']", fieldOfSearch, PropertyType.XPath);
        SetMethod.Click("//span[@class='glyphicon glyphicon-search']", PropertyType.XPath);
        PropertiesCollection.GetDrivers().findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.TAB, Keys.SPACE);

        List<WebElement> stacksAfterSearch = PropertiesCollection.GetDrivers().findElements(By.xpath("//div[@class=\"clearfix thumbnail app-box vertical-align padd-0\"]"));
         Assert.assertFalse( "Коль-во стеков до и после поиска не совпадают", counter.size() != stacksAfterSearch.size());
        }

    @After
    public  void CleanUp() {
        try {
            if (PropertiesCollection.GetDrivers() != null) {
                PropertiesCollection.GetDrivers().close();
            }
        } catch (TimeoutException | NoSuchSessionException ignored) {

        }
    }

    }
