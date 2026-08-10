package stepdefinitions.commerce;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ProposalData;
import pages.commerce.CreateProposalPage;
import pages.commerce.ProposalDetailsPage;
import pages.commerce.ProposalListPage;
import pages.common.HeaderComponent;
import utils.ProposalFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ProposalSteps {
    HeaderComponent headerComponent;
    CreateProposalPage createProposalPage;
    ProposalDetailsPage proposalDetailsPage;
    ProposalListPage proposalListPage;
    ProposalData proposal = ProposalFactory.DEFAULT_PROPOSAL;
    @And("the user is on commerce page")
    public void theUserIsOnCommercePage() {
        headerComponent.clickCommercial();
    }

    @And("the user is on new proposal page")
    public void theUserIsOnNewProposalPage() {
        createProposalPage.navigateToNewProposal();
    }

    @When("the user starts creating the proposal information")
    public void theUserStartsCreatingTheProposalInformation() {
        createProposalPage.fillProposalForm(proposal);
    }

    @And("the user saves the proposal information")
    public void theUserSavesTheProposalInformation() {
        createProposalPage.saveProposal();
        proposalDetailsPage.setProposalId(proposal);
    }

    @Then("the proposal details page should be displayed")
    public void theProposalDetailsPageShouldBeDisplayed() {
        assertThat(proposalDetailsPage.isProposalDetailDisplayed()).isTrue();
    }

    @And("the user cancel the proposal information")
    public void theUserCancelTheProposalInformation() {
        createProposalPage.cancelProposal();
    }


    @Then("the proposal should not be created")
    public void theProposalShouldNotBeCreated() {
        assertThat(proposalListPage.isListTableDisplayed()).isTrue();
    }

    @Given("the user has created a proposal")
    public void theUserHasCreatedAProposal() {
        createProposalPage.fillProposalForm(proposal);
        createProposalPage.saveProposal();
        proposalDetailsPage.setProposalId(proposal);
    }

    @When("the user searches for the customer by ID")
    public void theUserSearchesForTheCustomerByID() {
        proposalListPage.navigateToList();
        proposalListPage.selectProposal(proposal);
    }

    @Then("the proposal should appear in the search results")
    public void theProposalShouldAppearInTheSearchResults() {
        assertThat(proposalListPage.isThereResultProposal()).isTrue();
    }
}
