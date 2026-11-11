package org.example.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ui.pages.LoginPage;
import org.example.ui.pages.SecureAreaPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("the user enter the valid credentials")
    public void theUserEnterTheValidCredentials() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }

    @Then("the user should see welcome page")
    public void theUserShouldSeeWelcomePage() {
        assertTrue(secureAreaPage.flashText().contains("You logged into a secure area!"));
    }
}