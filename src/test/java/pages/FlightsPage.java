package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightsPage extends BasePage {

    @FindBy(name ="passCount")
    private WebElement passengerSelector;

    @FindBy(name="findFlights")
    private WebElement submitButton;

    @Autowired
    public FlightsPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void selectNumberOfPassengers(int numberOfPassengers){
        getWait().until(ExpectedConditions.visibilityOf(passengerSelector));
        Select select = new Select(passengerSelector);
        select.selectByValue(String.valueOf(numberOfPassengers));
    }

    public void goToFlightFindPage(){
        submitButton.click();
    }

}
