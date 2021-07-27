package configuration;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import utils.factory.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan(basePackages = {"pages", "base", "tests"})
@PropertySource("classpath:/properties/driver.properties")
public class Driver {

    @Value("${browser.type:chrome}")
    private Browser browserType;

    @Value("${remote.run:false}")
    private boolean isRemote;

    @Value("${remote.host:http://localhost:4444/wd/hub}")
    private String host;

    private DesiredCapabilities desiredCapabilities;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {
        if (isRemote) {
            switch (browserType) {
                case chrome:
                    desiredCapabilities = DesiredCapabilities.chrome();
                    break;

                case firefox:
                    desiredCapabilities = DesiredCapabilities.firefox();
                    break;

                case ie:
                    desiredCapabilities = DesiredCapabilities.edge();
                    break;

                default:
                    break;
            }
            return new RemoteWebDriver(new URL(host), desiredCapabilities);
        }
        return DriverFactory.setUpDriver(browserType);
    }

    @Bean
    public WebDriverWait webDriverWait() throws MalformedURLException {
        return new WebDriverWait(webDriver(), 10);
    }
}
