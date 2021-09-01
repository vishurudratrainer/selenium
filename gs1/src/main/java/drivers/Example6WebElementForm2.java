package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class Example6WebElementForm2 {

    public static void main(String args[]) {
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String baseUrl = "D:\\seleniumlab\\gs1\\src\\main\\resources\\html\\example6.html";

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("psw"));
        WebElement repeatPassword = driver.findElement(By.name("psw-repeat"));
        email.sendKeys("vishurudra@gmail.com");
        password.sendKeys("hellohowru");
        repeatPassword.sendKeys("hellohowru");
        log.info("Text Field Set");

        driver.findElement(By.id("emailForm")).submit();

        log.info("Submit Done with Click");
        String URL= driver.getCurrentUrl();
        log.info("Current URL {} ",URL);

       driver.quit();

    }
}
