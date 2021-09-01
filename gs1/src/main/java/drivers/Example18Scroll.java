package drivers;

import drivers.util.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Example18Scroll {
    public static void main(String args[]) throws AWTException {
        String chromeDriverPath = PathUtil.CHROME_DRIVER;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

       

        driver.get("https://www.browserstack.com/");

        //Scroll down the webpage by 4500 pixels
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 4500)");
        try {
            synchronized (driver) {
                driver.wait(2000);
            }
        } catch (InterruptedException e) {
            log.error("Exception e", e);
        }

        driver.quit();
    }
    }
