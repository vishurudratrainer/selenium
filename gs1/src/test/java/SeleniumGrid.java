import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.remote.RemoteWebDriver;



public class SeleniumGrid {

    WebDriver driver;
    String baseURL, nodeURL;

    @Before
    public void setUp() throws MalformedURLException {

    }

    @After
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        baseURL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
        nodeURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("marionette", "true");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        capabilities.setCapability("seleniumProtocol","WebDriver");
        capabilities.setCapability("platform", "WIN10");
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.INFO);
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.CLIENT, Level.INFO);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), firefoxOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        driver.get(baseURL);

        String data = driver.getPageSource();;
        if (data.contains("John")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

}
