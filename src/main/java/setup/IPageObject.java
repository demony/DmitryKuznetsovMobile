package setup;

import java.util.List;
import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWebElement(String elementName)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    List<WebElement> getWebElements(String elementName)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
