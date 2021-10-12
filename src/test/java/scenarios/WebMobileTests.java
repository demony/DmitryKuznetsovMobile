package scenarios;

import static org.assertj.core.api.Assertions.assertThat;

import dataproviders.WebDataProvider;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage", enabled = false)
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle()
                                        .equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

    @Test(groups = {"web"}, description = "Check that google search is relevant",
        dataProvider = "searchStringsForGoogle", dataProviderClass = WebDataProvider.class, enabled = true)
    public void googleSearchTest(String searchCase,
                                 String searchText,
                                 String relevantText)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get("https://google.com");
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        getPageObject().getWebElement("searchRequest").sendKeys(searchText, Keys.RETURN);
        List<WebElement> searchResults = getPageObject().getWebElements("searchResult");
        String resultAsString = searchResults.stream()
                                             .map(WebElement::getText)
                                             .collect(Collectors.toList())
                                             .toString();
        assertThat(resultAsString)
            .as("There are some relevant results")
            .containsIgnoringCase(relevantText);
    }
}
