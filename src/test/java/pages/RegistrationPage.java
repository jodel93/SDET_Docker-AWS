package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.builder.User;

@Component
public class RegistrationPage extends BasePage {

    @FindBy(name="firstName")
    private WebElement firstNameInput;

    @FindBy(name="lastName")
    private WebElement lastNameInput;

    @FindBy(name ="phone")
    private WebElement phoneInput;

    @FindBy(name="userName")
    private WebElement emailInput;

    @FindBy(name="email")
    private WebElement userNameInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(name="confirmPassword")
    private WebElement passwordConfirmInput;

    @FindBy(name="register")
    private WebElement submitButton;

    @Autowired
    public RegistrationPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void navigateToRegistration(){
        navigateTo("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        getWait().until(ExpectedConditions.visibilityOf(firstNameInput));
    }

    public void fillUserPersonalData(User user){
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        phoneInput.sendKeys(user.getPhone());
        emailInput.sendKeys(user.getEmail());
    }

    public void fillUserCredentials(User user){
        userNameInput.sendKeys(user.getUserID());
        passwordInput.sendKeys(user.getPassword());
        passwordConfirmInput.sendKeys(user.getConfirmPassword());
    }

    public void submitInfo(){
        submitButton.click();
    }
}
