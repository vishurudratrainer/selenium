package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class Example8WebelementRadioAlt {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String baseUrl = "D:\\seleniumlab\\gs1\\src\\main\\resources\\html\\example8.html";
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);


        WebElement text =driver.findElement(By.id("text"));
        WebElement yes = driver.findElement(By.id("yes"));
        WebElement button = driver.findElement(By.className("btnClass"));
        log.info("Before radio box click {}", text.getText());
        yes.click();
        button.click();
        try {
            synchronized (driver)
            {
                driver.wait(2000);
            }
        } catch (InterruptedException e) {
            log.error("Exception e",e);
        }
        log.info("After radio  click {}", text.getText());

        driver.quit();

    }
}
