package drivers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Example4Browser {

    public static void  main(String args[]){
        String baseUrl = "https://www.google.com/";
        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
        String URL= driver.getCurrentUrl();
        log.info("Current URL {} ",URL);

        driver.navigate().to("https://www.mit.edu");

        log.info(" URL after navigating  {} ",driver.getCurrentUrl());


       log.info(" Going back to google");

        driver.navigate().back();
        URL= driver.getCurrentUrl();
        log.info("Current URL after back {} ",URL);
      //  driver.navigate().refresh();
        driver.close(); //Closed opened window
     //   driver.quit(); closes all opened window
    }
}
