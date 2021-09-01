package drivers;

import drivers.util.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Example17Alert {

    public static void main(String args[]) throws AWTException {
        String chromeDriverPath = PathUtil.CHROME_DRIVER;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Launch Website
//        driver.navigate().to("D:\\seleniumlab\\gs1\\src\\main\\resources\\html\\example16.html");


        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

        driver.findElement(By.cssSelector(".row:nth-child(20) button")).click();

        //Using Alert class to first switch to or focus to the alert box
        Alert alert = (Alert) driver.switchTo().alert();

        //Using accept() method to accept the alert box
        alert.accept();

        //Handling confirm box
        //Click on Generate Confirm Box
        driver.findElement(By.cssSelector(".row:nth-child(22) button")).click();



        Alert confirmBox = (Alert) driver.switchTo().alert();

        //Using dismiss() command to dismiss the confirm box
        //Similarly accept can be used to accept the confirm box
        ((Alert) confirmBox).dismiss();
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
