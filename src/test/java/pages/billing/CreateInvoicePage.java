package pages.billing;

import models.InvoiceData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static components.FormUtils.*;

public class CreateInvoicePage extends PageObject {
    @FindBy(css = "a[href='/compta/facture/card.php?action=create&leftmenu=']")
    private WebElementFacade newInvoiceButton;
    @FindBy (id = "select2-socid-container") private WebElementFacade customerDropdown;
    @FindBy (id = "re") private WebElementFacade invoiceDatePicker;
    @FindBy (id = "select2-cond_reglement_id-container") private WebElementFacade termnsDropdown;
    @FindBy (id = "select2-selectmode_reglement_id-container") private WebElementFacade methodDropdown;
    @FindBy (id = "select2-selectfk_account-container") private WebElementFacade accountDropdown;
    @FindBy (id = "select2-select_input_reason_id-container") private WebElementFacade sourceDropdown;
    @FindBy (className = "button-save") private WebElementFacade saveButton;
    @FindBy (className = "button-cancel") private WebElementFacade cancelButton;


    public void navigateToNewInvoice() {
        newInvoiceButton.click();
    }

    public void fillInvoiceForm(InvoiceData invoice) {
        selectIfNotInvalid(customerDropdown, invoice.getCustomerIndex());
        typeIfNotNull(invoiceDatePicker, invoice.getDate());
        selectIfNotNull(termnsDropdown, invoice.getPaymentTerms());
        selectIfNotNull(methodDropdown, invoice.getPaymentMethod());
        selectIfNotNull(accountDropdown, invoice.getBankAccount());
        selectIfNotNull(sourceDropdown, invoice.getSource());
    }

    public void savesInvoice() {
        saveButton.click();
    }

    public void cancelInvoice() {
        cancelButton.click();
    }
}
