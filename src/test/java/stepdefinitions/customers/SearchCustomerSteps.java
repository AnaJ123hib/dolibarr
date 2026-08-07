package stepdefinitions.customers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CustomerData;
import pages.authentication.LoginPage;
import pages.customers.CreateCustomerPage;
import pages.customers.CustomerListPage;
import utils.ConfigManager;
import utils.CustomerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchCustomerSteps {
    CustomerListPage customerListPage;
    CreateCustomerPage createCustomerPage;
    LoginPage loginPage;
    private String searchType;
    CustomerData customer = CustomerFactory.DEFAULT_CUSTOMER;

    @Given("the user is on List member page")
    public void theUserIsOnListMemberPage() {
        loginPage.openSite();
        loginPage.login(ConfigManager.getUsername(), ConfigManager.getPassword());
        createCustomerPage.navigateToMembersPage();
        customerListPage.navigateToListMembers();
    }

    @When("the user searches for the customer by {string}")
    public void theUserSearchesForTheCustomerBySearchType(String searchType) {
        customerListPage.navigateToListMembers();
        this.searchType = searchType;
        customerListPage.selectCustomer(customer, searchType);
    }

    @Then("the customer should appear in the search results")
    public void theCustomerShouldAppearInTheSearchResults() {
        String actual = customerListPage.getValueFromTable(searchType);
        switch (searchType) {
            case "ID":
                assertThat(actual).isEqualTo(customer.getId());
                break;
            case "Name":
                assertThat(actual).isEqualTo(customer.getFirstName());
                break;
        }
    }

    @When("the user searches for a non-existing customer")
    public void theUserSearchesForANonExistingCustomer() {
        customerListPage.selectCustomer(CustomerFactory.RANDOM_CUSTOMER);
    }

    @Then("the user should see any customers in the search results")
    public void theUserShouldSeeAnyCustomersInTheSearchResults() {
        assertThat(customerListPage.isThereResultsInCustomer()).isFalse();
    }
}
