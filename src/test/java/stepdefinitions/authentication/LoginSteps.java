package stepdefinitions.authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.authentication.LoginPage;
import utils.ConfigManager;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("the user is on the Login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.openSite();
    }

    @When("the user logins with valid credentials")
    public void theUserLoginsWithValidCredentials() {
        loginPage.login(ConfigManager.getUsername(), ConfigManager.getPassword());
    }

    @Then("the dashboard page should be displayed")
    public void theDashboardPageShouldBeDisplayed() {
        assertThat(dashboardPage.isDisplayed()).isTrue();
    }

    @When("the user attempts to login with an invalid username")
    public void theUserAttemptsToLoginWithAnInvalidUsername() {
        loginPage.login("wrong_user", ConfigManager.getPassword());
    }

    @When("the user attempts to login with an invalid password")
    public void theUserAttemptsToLoginWithAnInvalidPassword() {
        loginPage.login(ConfigManager.getUsername(), "wrong_password");
    }

    @Then("the user should see an authentication error message")
    public void theUserShouldSeeAnAuthenticationErrorMessage() {
        assertThat(loginPage.isErrorMessageDisplayed()).isTrue();
    }
}
