package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject  {

    private static final String PACKAGE = "platkovsky.alexey.epamtestapp";
    private static final String PACKAGE_PREFIX = PACKAGE + ":id/";

    // Main page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = PACKAGE_PREFIX + "login_email")
    WebElement emailInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = PACKAGE_PREFIX + "login_pwd")
    WebElement passwordInput;

    @iOSXCUITFindBy(xpath = "////XCUIElementTypeStaticText[@label='Sign In']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "email_sign_in_button")
    WebElement signInButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = PACKAGE_PREFIX + "register_button")
    WebElement registerButton;

    // Registration page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_email")
    WebElement newUserEmailInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_username")
    WebElement newUserNameInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_password")
    WebElement newUserPasswordInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_confirm_password")
    WebElement newUserPasswordConfirmInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement newUserAgreementsCheckBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    @AndroidFindBy(id = PACKAGE_PREFIX + "register_new_account_button")
    WebElement registerNewAccountButton;

    // Expenses page
    @AndroidFindBy(id = PACKAGE_PREFIX + "expenses_list")
    List<WebElement> expensesList;
    @AndroidFindBy(id = PACKAGE_PREFIX + "add_new_expense")
    WebElement addNewExpensesButton;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@value='Budget']")
    WebElement pageHeaderBudget;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
