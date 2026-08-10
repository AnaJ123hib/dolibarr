package stepdefinitions.customers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.HeaderComponent;
import pages.customers.CreateCustomerPage;
import pages.customers.CustomerDetailsPage;
import utils.CustomerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateCustomerSteps {
    CreateCustomerPage createCustomerPage;
    CustomerDetailsPage customerDetailsPage;
    HeaderComponent headerComponent;
    @And("the user is on the create customer page")
    public void theUserIsOnTheCreateCustomerPage() {
        headerComponent.clickMember();
        createCustomerPage.navigateToNewMemberPage();
    }

    @When("the user creates a new customer with valid information")
    public void theUserCreatesANewCustomerWithValidInformation() {
        createCustomerPage.fillCustomerForm(CustomerFactory.DEFAULT_CUSTOMER);
        createCustomerPage.saveCustomerData();
    }

    @Then("the customer details page should be displayed")
    public void theCustomerDetailsPageShouldBeDisplayed() {
        assertThat(customerDetailsPage.customerUsernameIsDisplayed(CustomerFactory.DEFAULT_CUSTOMER)).isTrue();
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
        assertThat(customerDetailsPage.isCustomerDisplayed(CustomerFactory.RANDOM_CUSTOMER)).isFalse();
    }

    @When("the user attempts to create a customer without {string}")
    public void theUserAttemptsToCreateACustomerWithout(String field) {
        createCustomerPage.fillCustomerForm(CustomerFactory.getCustomerWithoutField(field));
        createCustomerPage.saveCustomerData();
    }
}
