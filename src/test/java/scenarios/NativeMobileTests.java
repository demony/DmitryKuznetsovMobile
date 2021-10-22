package scenarios;

import static org.assertj.core.api.Assertions.assertThat;

import dto.User;
import dto.UserGenerator;
import org.testng.annotations.Test;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button", enabled = true)
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebElement("signInButton").click();
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Work with new account test - create and login", enabled = true)
    public void newAccountTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        // User registration
        User newUser =  UserGenerator.getNewUser(
            testProperties.getUserName(), testProperties.getUserEmail(), testProperties.getUserPassword());
        getPageObject().getWebElement("registerButton").click();
        getPageObject().getWebElement("newUserEmailInput")
                       .sendKeys(newUser.getEmail());
        getPageObject().getWebElement("newUserNameInput")
                       .sendKeys(newUser.getName());
        getPageObject().getWebElement("newUserPasswordInput")
                       .sendKeys(newUser.getPassword());
        getPageObject().getWebElement("newUserPasswordConfirmInput")
                       .sendKeys(newUser.getPassword());
        getPageObject().getWebElement("newUserAgreementsCheckBox").click();
        getPageObject().getWebElement("registerNewAccountButton").click();

        // User login
        getPageObject().getWebElement("emailInput")
                       .sendKeys(newUser.getEmail());
        getPageObject().getWebElement("passwordInput")
                       .sendKeys(newUser.getPassword());
        getPageObject().getWebElement("signInButton").click();

        assertThat(getPageObject().getWebElements("expensesList"))
            .as("After login user should be on BudgetActivity page")
            .isNotEmpty();
        System.out.println("Simplest Android native test done");
    }
}
