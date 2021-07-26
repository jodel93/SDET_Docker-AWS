package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDetailsPage extends BasePage {

    @FindBy(xpath ="//font[contains(text(),'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @Autowired
    public FlightDetailsPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void printConfirmation(){
        getWait().until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
    }

}
