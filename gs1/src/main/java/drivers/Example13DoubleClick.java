package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class Example13DoubleClick {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();

        //
        driver.get("https://www.browserstack.com/");



Actions ac = new Actions(driver);

        WebElement trialaction = driver.findElement(By.xpath("/html/body/div[1]/main/section/article/div[1]/div[1]/div/div/article/div/div/div/div[1]/div/div/div/div/span[1]/a"));
        log.info("trial action {}",trialaction);
        ac.doubleClick(trialaction).perform();

        try {
            synchronized (driver)
            {
                driver.wait(2000);
            }
        } catch (InterruptedException e) {
            log.error("Exception e",e);
        }


        log.info("final url {}",driver.getCurrentUrl());
        driver.quit();
    }
}
