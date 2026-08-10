package stepdefinitions.customers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.HeaderComponent;
import pages.customers.CreateCustomerPage;
import pages.customers.CustomerDetailsPage;
import utils.CustomerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateCustomerSteps {
    CustomerDetailsPage customerDetailsPage;
    CreateCustomerPage createCustomerPage;
    HeaderComponent headerComponent;

    @And("the user has created a customer")
    public void theUserHasCreatedACustomer() {
        headerComponent.clickMember();
        createCustomerPage.navigateToNewMemberPage();
        createCustomerPage.fillCustomerForm(CustomerFactory.DEFAULT_CUSTOMER);
        createCustomerPage.saveCustomerData();
        createCustomerPage.setCustomerId(CustomerFactory.DEFAULT_CUSTOMER);
    }

    @Then("the updated customer information should be displayed")
    public void theUpdatedCustomerInformationShouldBeDisplayed() {
        assertThat(customerDetailsPage.customerUsernameIsDisplayed(CustomerFactory.EDITED_CUSTOMER)).isTrue();
    }

    @When("the user starts editing the customer information")
    public void theUserStartsEditingTheCustomerInformation() {
        customerDetailsPage.goToModifyCustomer();
        createCustomerPage.fillCustomerForm(CustomerFactory.EDITED_CUSTOMER);
    }

    @And("the user cancels the update")
    public void theUserCancelsTheUpdate() {
        createCustomerPage.cancelCreateCustomer();
    }

    @And("the user saves the customer information")
    public void theUserSavesTheCustomerInformation() {
        createCustomerPage.saveCustomerData();
    }

    @Then("the original customer information should remain unchanged")
    public void theOriginalCustomerInformationShouldRemainUnchanged() {
        assertThat(customerDetailsPage.customerUsernameIsDisplayed(CustomerFactory.DEFAULT_CUSTOMER)).isTrue();
    }

    @When("the user updates the customer leaving the {string} empty")
    public void theUserUpdatesTheCustomerLeavingTheEmpty(String field) {
        customerDetailsPage.goToModifyCustomer();
        createCustomerPage.leaveSpaceBlank(field);
        createCustomerPage.saveCustomerData();
    }
}
