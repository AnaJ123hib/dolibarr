package stepdefinitions.billing;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.InvoiceData;
import pages.billing.CreateInvoicePage;
import pages.billing.InvoiceDetailsPage;
import pages.common.HeaderComponent;
import utils.InvoiceFactory;
import utils.LineFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class InvoiceSteps {
    HeaderComponent headerComponent;
    InvoiceDetailsPage invoiceDetailsPage;
    CreateInvoicePage createInvoicePage;
    InvoiceData invoice = InvoiceFactory.DEFAULT_INVOICE;
    @And("the user is on billing page")
    public void theUserIsOnBillingPage() {
        headerComponent.clickBilling();
    }

    @Given("the user is on new invoice page")
    public void theUserIsOnNewInvoicePage() {
        createInvoicePage.navigateToNewInvoice();
    }

    @When("the user starts creating the invoice information")
    public void theUserStartsCreatingTheInvoiceInformation() {
        createInvoicePage.fillInvoiceForm(invoice);
    }

    @And("the user saves the invoice information")
    public void theUserSavesTheInvoiceInformation() {
        createInvoicePage.savesInvoice();
        invoiceDetailsPage.setOrderId(invoice);
    }

    @Then("the invoice details page should be displayed")
    public void theInvoiceDetailsPageShouldBeDisplayed() {
        assertThat(invoiceDetailsPage.isBillingDetailDisplayed()).isTrue();
    }

    @Given("the user has created a invoice")
    public void theUserHasCreatedAInvoice() {
        createInvoicePage.navigateToNewInvoice();
        createInvoicePage.fillInvoiceForm(invoice);
        createInvoicePage.savesInvoice();
    }

    @When("the user adds a new line in the invoice")
    public void theUserAddsANewLineInTheInvoice() {
        invoiceDetailsPage.addLine(LineFactory.DEFAULT_LINE);
    }

    @Then("the new line should be included in the invoice")
    public void theNewLineShouldBeIncludedInTheInvoice() {
        assertThat(invoiceDetailsPage.isLineRecords()).isTrue();
    }

    @And("the user has added a line")
    public void theUserHasAddedALine() {
        invoiceDetailsPage.addLine(LineFactory.DEFAULT_LINE);
    }

    @When("the user validates the invoice")
    public void theUserValidatesTheInvoice() {
        invoiceDetailsPage.validateLine();
    }

    @Then("the invoice status should be changed to not pay")
    public void theInvoiceStatusShouldBeChangedToNotPay() {
        assertThat(invoiceDetailsPage.isInvoiceNotPaid()).isTrue();
    }
}
