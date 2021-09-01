package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Example1Browser {

    public static void  main(String args[]){
        String baseUrl = "https://www.google.com/";
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL= driver.getCurrentUrl();
        log.info("URL {} ",URL);

        String title = driver.getTitle();
        log.info("Title {}",title);

        String completeSourceCode = driver.getPageSource();
        log.info("Source code {}",completeSourceCode);

        driver.close(); //Closed opened window
     //   driver.quit(); closes all opened window
    }
}
