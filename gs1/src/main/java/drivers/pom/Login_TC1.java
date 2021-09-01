package drivers.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login_TC1 {

    public static void main(String[] args) throws InterruptedException {

        String chromeDriverPath="D:\\seleniumeg\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/books");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of Login page
        LoginPage login = new LoginPage(driver);

        //Creating object of Dashboard
        Dashboard dashboard = new Dashboard(driver);

        //Click on Login button
        home.clickLogin();

        //Enter username & password
        login.enterUsername("---Your Username---");
        login.enterPassword("---Your Password---");

        //Click on login button
        login.clickLogin();
        Thread.sleep(3000);


        //Capture the page heading and print on console
        System.out.println("The page heading is --- " +dashboard.getHeading());

        //Click on Logout button
        dashboard.clickLogout();

        //Close browser instance
        driver.quit();
    }

}
