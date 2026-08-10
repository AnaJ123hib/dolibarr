package pages.commerce;

import models.ProposalData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import static components.FormUtils.*;

public class CreateProposalPage extends PageObject {
    @FindBy(className = "menu_contenu_supplier_proposal_card")
    private WebElementFacade newProposalButton;
    @FindBy (id = "select2-socid-container") private WebElementFacade vendedorDropdown;
    @FindBy (id = "select2-cond_reglement_id-container") private WebElementFacade termsDropdown;
    @FindBy (id = "select2-selectmode_reglement_id-container") private WebElementFacade methodDropdown;
    @FindBy (id = "liv_") private WebElementFacade deliveryDatePicker;
    @FindBy (className = "button-save") private WebElementFacade saveButton;
    @FindBy (className = "button-cancel") private WebElementFacade cancelButton;

    public void navigateToNewProposal() {
        newProposalButton.click();
    }

    public void fillProposalForm(ProposalData proposal) {
        selectIfNotInvalid(vendedorDropdown, proposal.getVendorIndex());
        selectIfNotNull(termsDropdown, proposal.getPaymentTerms());
        selectIfNotNull(methodDropdown, proposal.getPaymentMethod());
        typeIfNotNull(deliveryDatePicker, proposal.getDeliveryDate());
    }

    public void saveProposal() { saveButton.click();}
    public void cancelProposal() {cancelButton.click();}
}
