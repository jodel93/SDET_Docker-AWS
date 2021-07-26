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
public class FlightSelectionPage extends BasePage {

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitButton;

    @FindBy(name ="buyFlights")
    private WebElement secondSubmitButton;

    @Autowired
    public FlightSelectionPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void goToFlightDetailsPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(firstSubmitButton));
        firstSubmitButton.click();
        getWait().until(ExpectedConditions.elementToBeClickable(secondSubmitButton));
        secondSubmitButton.click();
    }

}
