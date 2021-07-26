package configuration;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import utils.factory.DriverFactory;

@Configuration
@ComponentScan(basePackages = {"pages", "base", "tests"})
@PropertySource("classpath:/properties/driver.properties")
public class Driver {

    @Value("${browser.type}")
    private Browser browserType;

    @Bean
    public WebDriver webDriver(){
        return DriverFactory.setUpDriver(browserType);
    }

    @Bean
    public WebDriverWait webDriverWait(){
        return new WebDriverWait(webDriver(), 10);
    }
}
