package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Example3Edge {

    public static void  main(String args[]){
        String baseUrl = "https://www.mit.edu/";
        String edgeDriverPath="D:\\seleniumeg\\edgedriver_win64\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgeDriverPath);

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL= driver.getCurrentUrl();
        System.out.print(URL);

        String title = driver.getTitle();
        System.out.println(title);
    }
}
