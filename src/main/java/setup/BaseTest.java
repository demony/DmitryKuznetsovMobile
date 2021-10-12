package setup;

import static java.lang.String.format;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver;
    private static IPageObject pageObject;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPageObject() {
        return pageObject;
    }

    @Parameters({"useCloud", "platformName", "appType", "deviceName", "udid",
        "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(
        @Optional("") Boolean useCloud,
        @Optional("") String platformName,
        @Optional("") String appType,
        @Optional("") String deviceName,
        @Optional("") String udid,
        @Optional("") String browserName,
        @Optional("") String app,
        @Optional("") String appPackage,
        @Optional("") String appActivity,
        @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type - " + appType + " useCloud: " + useCloud);
        setAppiumDriver(useCloud, platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);
    }

    @Parameters({"useCloud"})
    @AfterSuite(alwaysRun = true)
    public void tearDown(Boolean useCloud) throws Exception {
        System.out.println("After");
        if (useCloud) {
            // After tests the device will be in preparing status,
            // it prevents tests from errors on cloud side
            appiumDriver.quit();
        } else {
            appiumDriver.closeApp();
        }
    }

    private void setAppiumDriver(Boolean useCloud, String platformName, String deviceName, String udid,
                                 String browserName, String app, String appPackage, String appActivity,
                                 String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        if (app.endsWith(".apk")) {
            capabilities.setCapability(MobileCapabilityType.APP, (new File(app)).getAbsolutePath());
        }
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability(MobileCapabilityType.OVERLAPPING_CHECK_DISABLED, "true");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);
        try {
            appiumDriver = new AppiumDriver(getAppiumUrl(useCloud), capabilities);
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private URL getAppiumUrl(Boolean useCloud) throws UnsupportedEncodingException, MalformedURLException {
        if (useCloud) {
            String cloudKey = URLEncoder.encode(System.getProperty("cloud.api.token"), StandardCharsets.UTF_8.name());
            return new URL(format(System.getProperty("td.appium.cloud"), cloudKey));
        } else {
            return new URL(System.getProperty("ts.appium"));
        }
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new PageObject(appType, appiumDriver);
    }
}
