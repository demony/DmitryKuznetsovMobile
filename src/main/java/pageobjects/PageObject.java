package pageobjects;

import io.appium.java_client.AppiumDriver;
import java.lang.reflect.Field;
import java.util.List;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

public class PageObject implements IPageObject {

    Object somePageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativePageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for " + appType);
        }
    }

    @Override
    public WebElement getWebElement(String elementName) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);
    }

    @Override
    public List<WebElement> getWebElements(String elementName) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(somePageObject);
    }

}
