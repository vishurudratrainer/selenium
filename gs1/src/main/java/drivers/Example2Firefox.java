package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Example2Firefox {

    public static void  main(String args[]){
        String baseUrl = "https://www.mit.edu/";
        String firefoxDriverPath="D:\\seleniumeg\\geckodriver-v0.29.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL= driver.getCurrentUrl();
        System.out.print(URL);

        String title = driver.getTitle();
        System.out.println(title);
    }
}
