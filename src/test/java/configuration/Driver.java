package configuration;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
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

    private String host;

    private DesiredCapabilities desiredCapabilities;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {

        if(isRemote){

            if(System.getProperty("HOST") != null)
                host = System.getProperty("HOST");
            else host = "localhost";

            if(System.getProperty("BROWSER") != null &&
                    System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
                desiredCapabilities = DesiredCapabilities.firefox();
            }

            else if(System.getProperty("BROWSER") != null &&
                    System.getProperty("BROWSER").equalsIgnoreCase("edge")){
                desiredCapabilities = DesiredCapabilities.edge();
            }

            else
            {
                desiredCapabilities = DesiredCapabilities.chrome();
            }

            return new RemoteWebDriver(new URL("http://"+ host + ":4444/wd/hub"), desiredCapabilities);
        }

        return DriverFactory.setUpDriver(browserType);
    }

    @Bean
    public WebDriverWait webDriverWait() throws MalformedURLException {
        return new WebDriverWait(webDriver(), 10);
    }
}
