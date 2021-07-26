package tests;

import base.BaseTest;
import configuration.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.*;
import utils.builder.UserBuilder;

@DirtiesContext //Used to delete the context and create a new one "ClassMode.AFTER_CLASS" by default
@ContextConfiguration(classes = {Driver.class})
public class BookAFlightTest extends BaseTest {

    @Autowired
    private RegistrationPage registrationPage;

    @Autowired
    private RegistrationConfirmPage registrationConfirmPage;

    @Autowired
    private FlightsPage flightsPage;

    @Autowired
    private FlightSelectionPage flightSelectionPage;

    @Autowired
    private FlightDetailsPage flightDetailsPage;

    @Test
    public void registration(){
        registrationPage.navigateToRegistration();
        registrationPage.fillUserPersonalData(
                UserBuilder
                        .aUser()
                        .withDefaultInfo()
                        .build());
        registrationPage.fillUserCredentials(
                UserBuilder
                        .aUser()
                        .withDefaultInfo()
                        .build());
        registrationPage.submitInfo();
    }

    @Test(dependsOnMethods = "registration")
    public void confirmRegistration(){
        registrationConfirmPage.goToFlightsPage();
    }

    @Test(dependsOnMethods = "confirmRegistration")
    public void selectFlights(){
        flightsPage.selectNumberOfPassengers(3);
        flightsPage.goToFlightFindPage();
        flightSelectionPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "selectFlights")
    public void flightDetailsConfirmation(){
        flightDetailsPage.printConfirmation();
    }
}
