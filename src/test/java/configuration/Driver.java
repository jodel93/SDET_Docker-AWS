package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pages", "base", "tests"})
public class Driver {

    @Bean
    public WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(){
        return new WebDriverWait(webDriver(), 10);
    }
}
