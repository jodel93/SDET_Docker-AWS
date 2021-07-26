package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConfirmPage extends BasePage {

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @Autowired
    public RegistrationConfirmPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void goToFlightsPage(){
        getWait().until(ExpectedConditions.visibilityOf(signInLink));
        flightsLink.click();
    }
}
