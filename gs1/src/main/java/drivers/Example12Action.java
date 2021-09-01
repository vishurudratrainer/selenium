package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class Example12Action {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();

        //
        driver.get("https://www.browserstack.com/");

((JavascriptExecutor) driver).executeScript("scroll(0,300)");

Actions ac = new Actions(driver);

        WebElement live= driver.findElement(By. cssSelector("div.product-cards-wrapper--click a[title='Live']"));

        ac.moveToElement(live).build().perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
        automate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("final url {}",driver.getCurrentUrl());
        driver.quit();
    }
}
