package pageobjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject  {
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchRequest;

    @FindBy(xpath = "//div[@id='rso']/div")
    private List<WebElement> searchResult;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
