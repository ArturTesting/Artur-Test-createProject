package tryDirect;

//import BnpTests.PropertiesCollection;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.interactions.ClickAction;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class SetMethod {

    public static void EnterText(String element, String value, PropertyType elementType) {
        if (elementType == PropertyType.Id) {
            if (IsElementExists(By.id(element))) {
                PropertiesCollection.GetDrivers().findElement(By.id(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.id(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.Name) {
            if (IsElementExists(By.name(element))) {
                PropertiesCollection.GetDrivers().findElement(By.name(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.name(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.ClassName) {
            if (IsElementExists(By.className(element))) {
                PropertiesCollection.GetDrivers().findElement(By.className(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.className(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.TagName) {
            if (IsElementExists(By.tagName(element))) {
                PropertiesCollection.GetDrivers().findElement(By.tagName(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.tagName(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.XPath) {
            if (IsElementExists(By.xpath(element))) {
                PropertiesCollection.GetDrivers().findElement(By.xpath(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.xpath(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.CssSelector) {
            if (IsElementExists(By.cssSelector(element))) {
                PropertiesCollection.GetDrivers().findElement(By.cssSelector(element)).clear();
                PropertiesCollection.GetDrivers().findElement(By.cssSelector(element)).sendKeys(value);
            } else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
    }

    //click button or something like that
    public static void Click(String element, PropertyType elementType) {
        if (elementType == PropertyType.Id)
            if (IsElementExists(By.id(element)))
                PropertiesCollection.GetDrivers().findElement(By.id(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.Name)
            if (IsElementExists(By.name(element)))
                PropertiesCollection.GetDrivers().findElement(By.name(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.ClassName) {
            if (IsElementExists(By.className(element)))
                PropertiesCollection.GetDrivers().findElement(By.className(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.TagName)
            if (IsElementExists(By.tagName(element)))
                PropertiesCollection.GetDrivers().findElement(By.tagName(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.XPath)
            if (IsElementExists(By.xpath(element)))
                PropertiesCollection.GetDrivers().findElement(By.xpath(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.CssSelector)
            if (IsElementExists(By.cssSelector(element)))
                PropertiesCollection.GetDrivers().findElement(By.cssSelector(element)).click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
    }
    public static void Click(WebElement element, PropertyType elementType) {
            if (IsElementExists(element))
                element.click();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
    }

    public static void Scroll(String element, PropertyType elementType){
        if(elementType==PropertyType.Id){

//            ((JavascriptExecutor) PropertiesCollection.GetDrivers()).executeScript("arguments[0].scrollIntoView(true);", PropertiesCollection.GetDrivers().findElement(By.id(element)));
//            PropertiesCollection.Sleep(500);

           // WebElement element = driver.findElement(By.id("my-id"));
//            Actions actions = new Actions(PropertiesCollection.GetDrivers());
//            actions.moveToElement(PropertiesCollection.GetDrivers().findElement(By.id(element)));
//            actions.perform();


            Actions builder = new Actions(PropertiesCollection.GetDrivers());
            builder.moveToElement(PropertiesCollection.GetDrivers().findElement(By.id(element))).click().perform();

//            ((JavascriptExecutor)PropertiesCollection.GetDrivers()).executeScript("arguments[0].scrollIntoView();"
//                    ,PropertiesCollection.GetDrivers().findElement(By.id(element)));
        }
    }

    public static void Clear(String element, PropertyType elementType) {
        if (elementType == PropertyType.Id)
            if (IsElementExists(By.id(element)))
                PropertiesCollection.GetDrivers().findElement(By.id(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.Name)
            if (IsElementExists(By.name(element)))
                PropertiesCollection.GetDrivers().findElement(By.name(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.ClassName) {
            if (IsElementExists(By.className(element)))
                PropertiesCollection.GetDrivers().findElement(By.className(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        }
        if (elementType == PropertyType.TagName)
            if (IsElementExists(By.tagName(element)))
                PropertiesCollection.GetDrivers().findElement(By.tagName(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.XPath)
            if (IsElementExists(By.xpath(element)))
                PropertiesCollection.GetDrivers().findElement(By.xpath(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }
        if (elementType == PropertyType.CssSelector)
            if (IsElementExists(By.cssSelector(element)))
                PropertiesCollection.GetDrivers().findElement(By.cssSelector(element)).clear();
            else {
                System.out.println("элемент не найден. завершение теста, тест провален");
                Assert.fail();
            }

    }

    //open dropdown control
    public static void DropDown(String element, String value, PropertyType elementType) {
        if (elementType == PropertyType.Id)
            new Select(PropertiesCollection.GetDrivers().findElement(By.id(element))).selectByVisibleText(value);
        if (elementType == PropertyType.Name)
            new Select(PropertiesCollection.GetDrivers().findElement(By.name(element))).selectByVisibleText(value);
        if (elementType == PropertyType.ClassName)
            new Select(PropertiesCollection.GetDrivers().findElement(By.className(element))).selectByVisibleText(value);
        if (elementType == PropertyType.TagName)
            new Select(PropertiesCollection.GetDrivers().findElement(By.tagName(element))).selectByVisibleText(value);
        if (elementType == PropertyType.XPath)
            new Select(PropertiesCollection.GetDrivers().findElement(By.xpath(element))).selectByVisibleText(value);
    }

    public static Boolean IsElementExists(By locator) {
        try {
            if (PropertiesCollection.WaitElement(locator)) {
                PropertiesCollection.GetDrivers().findElement(locator);
                return true;
            } else return false;
        } catch (NoSuchElementException e) {
            System.out.println("элемент" + locator + " не найден");
            return false;
        }
    }
    public static Boolean IsElementExists(WebElement element) {
        try {
            //                PropertiesCollection.GetDrivers().findElement(By.E);
            return PropertiesCollection.WaitElement(element);
        } catch (NoSuchElementException e) {
            System.out.println("элемент" + element + " не найден");
            return false;
        }
    }
}
