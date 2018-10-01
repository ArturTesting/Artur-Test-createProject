package tryDirect;


import org.openqa.selenium.By;

public class GetMethod {
    public static String getTextFromInput(String element, PropertyType elementType)
    {
        if (elementType == PropertyType.Id)
            return PropertiesCollection.GetDrivers().findElement(By.id(element)).getText();
        if (elementType == PropertyType.Name)
            return PropertiesCollection.GetDrivers().findElement(By.name(element)).getText();
        if (elementType == PropertyType.ClassName)
            return PropertiesCollection.GetDrivers().findElement(By.className(element)).getText();
        if (elementType == PropertyType.XPath)
            return PropertiesCollection.GetDrivers().findElement(By.xpath(element)).getText();
        if (elementType == PropertyType.CssSelector)
            return PropertiesCollection.GetDrivers().findElement(By.cssSelector(element)).getText();
        else return "";
    }

    public static String getTextFromInputAttribute(String element, PropertyType elementType, AttributeType attributeType)
    {
        String value="";
        if(attributeType==AttributeType.value)
            value="value";
        if(attributeType==AttributeType.innerHTML)
            value="innerHTMl";
        if(attributeType==AttributeType.innerText)
            value="innerText";

        if (elementType == PropertyType.Id)
            return PropertiesCollection.GetDrivers().findElement(By.id(element)).getAttribute(value);
        if (elementType == PropertyType.Name)
            return PropertiesCollection.GetDrivers().findElement(By.name(element)).getAttribute(value);
        if (elementType == PropertyType.ClassName)
            return PropertiesCollection.GetDrivers().findElement(By.className(element)).getAttribute(value);
        if (elementType == PropertyType.XPath)
            return PropertiesCollection.GetDrivers().findElement(By.xpath(element)).getAttribute(value);
        else return "";
    }
}
