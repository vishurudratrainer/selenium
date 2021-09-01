package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class Example10LinkTextAlt {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String baseUrl = "D:\\seleniumlab\\gs1\\src\\main\\resources\\html\\example10.html";
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        //
        driver.findElement(By.linkText("click here")).click();
        log.info("title of page is: " + driver.getTitle());
        driver.quit();
    }
}
