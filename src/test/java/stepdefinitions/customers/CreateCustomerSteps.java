package stepdefinitions.customers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.customers.CreateCustomerPage;
import utils.CustomerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateCustomerSteps {
    CreateCustomerPage createCustomerPage;
    @And("the user is on the create customer page")
    public void theUserIsOnTheCreateCustomerPage() {
        createCustomerPage.navigateToMembersPage();
        createCustomerPage.navigateToNewMemberPage();
    }

    @When("the user creates a new customer with valid information")
    public void theUserCreatesANewCustomerWithValidInformation() {
        createCustomerPage.fillCustomerForm(CustomerFactory.DEFAULT_CUSTOMER);
        createCustomerPage.createCustomer();
    }

    @Then("the customer details page should be displayed")
    public void theCustomerDetailsPageShouldBeDisplayed() {
        assertThat(createCustomerPage.customerUsernameIsDisplayed(CustomerFactory.DEFAULT_CUSTOMER)).isTrue();
    }

    @When("the user attempts to create a customer without name")
    public void theUserAttemptsToCreateACustomerWithoutName() {
        createCustomerPage.fillCustomerForm(CustomerFactory.CUSTOMER_WITHOUT_NAME);
        createCustomerPage.createCustomer();
    }

    @When("the user attempts to create a customer without customer type")
    public void theUserAttemptsToCreateACustomerWithoutCustomerType() {
        createCustomerPage.fillCustomerForm(CustomerFactory.CUSTOMER_WITHOUT_TYPE);
        createCustomerPage.createCustomer();
    }

    @Then("a validation error message should be displayed")
    public void aValidationErrorMessageShouldBeDisplayed() {
        assertThat(createCustomerPage.isErrorMessageDisplayed()).isTrue();
    }

    @When("the user fills the customer form with valid information")
    public void theUserFillsTheCustomerFormWithValidInformation() {
        createCustomerPage.fillCustomerForm(CustomerFactory.RANDOM_CUSTOMER);
    }

    @And("the user clicks the Cancel button")
    public void theUserClicksTheCancelButton() {
        createCustomerPage.cancelCreateCustomer();
    }

    @Then("the customer should not be created")
    public void theCustomerShouldNotBeCreated() {
        assertThat(createCustomerPage.isCustomerDisplayed(CustomerFactory.RANDOM_CUSTOMER)).isFalse();
    }
}
