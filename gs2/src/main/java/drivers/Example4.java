package drivers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void  main(String args[]){
        String baseUrl = "https://www.mit.edu/";


        WebDriver driver = new HtmlUnitDriver(false);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL= driver.getCurrentUrl();
        System.out.print(URL);

        String title = driver.getTitle();
        System.out.println(title);
    }
}
