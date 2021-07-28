package utils.factory;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static String DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/driver/%s";
    private static WebDriver driver;

    public static WebDriver setUpDriver(Browser browser){
        if(Browser.chrome == browser){
            System.setProperty("webdriver.chrome.driver",
                    String.format(DRIVER_PATH, Browser.chrome.label));
            driver = new ChromeDriver();
        }
        if(Browser.firefox == browser){
            System.setProperty("webdriver.gecko.driver",
                    String.format(DRIVER_PATH, "geckodriver"));
            driver = new FirefoxDriver();
        }
        if(Browser.ie == browser){
            //For IE
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }
}
