package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject  {

    private static final String PACKAGE = "platkovsky.alexey.epamtestapp";
    private static final String PACKAGE_PREFIX = PACKAGE + ":id/";

    // Main page
    @AndroidFindBy(id = PACKAGE_PREFIX + "login_email")
    WebElement emailInput;
    @AndroidFindBy(id = PACKAGE_PREFIX + "login_pwd")
    WebElement passwordInput;
    @AndroidFindBy(id = PACKAGE_PREFIX + "email_sign_in_button")
    WebElement signInButton;
    @AndroidFindBy(id = PACKAGE_PREFIX + "register_button")
    WebElement registerButton;

    // Registration page
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_email")
    WebElement newUserEmailInput;
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_username")
    WebElement newUserNameInput;
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_password")
    WebElement newUserPasswordInput;
    @AndroidFindBy(id = PACKAGE_PREFIX + "registration_confirm_password")
    WebElement newUserPasswordConfirmInput;
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement newUserAgreementsCheckBox;
    @AndroidFindBy(id = PACKAGE_PREFIX + "register_new_account_button")
    WebElement registerNewAccountButton;

    // Expenses page
    @AndroidFindBy(id = PACKAGE_PREFIX + "expenses_list")
    List<WebElement> expensesList;
    @AndroidFindBy(id = PACKAGE_PREFIX + "add_new_expense")
    WebElement addNewExpensesButton;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
}
