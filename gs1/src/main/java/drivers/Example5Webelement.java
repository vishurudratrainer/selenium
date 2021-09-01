package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Example5Webelement {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("D:\\seleniumlab\\gs1\\src\\main\\resources\\html\\example5.html");

// Find the radio button for “No” using its ID and click on it
        driver.findElement(By.id("no")).click();

//Click on Check Button
        driver.findElement(By.id("buttoncheck")).click();
        List<WebElement> elements = driver.findElements(By.name("name"));
       log.info("Number of elements:" +elements.size());

        for (int i=0; i<elements.size();i++) {
            log.info("Radio button text:" + elements.get(i).getAttribute("value"));
        }

       log.info("Text {}",  driver.findElement(By.id("text")).getText());
        try {
            synchronized (driver)
            {
                driver.wait(5000);
            }
        } catch (InterruptedException e) {
          log.error("Exception e",e);
        }finally {
            driver.quit();
        }

    }
}
